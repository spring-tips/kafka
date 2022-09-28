package bootiful;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.File;
import java.util.Map;

import static bootiful.SpringKafkaApplication.GREETINGS;
import static bootiful.SpringKafkaApplication.NOTIFICATIONS;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	final static String GREETINGS = "greetings";

	final static String NOTIFICATIONS = "notifications";

}

@Slf4j
@Configuration
class SpringKafkaConfiguration {

	@KafkaListener(id = GREETINGS, topics = GREETINGS)
	public void listen(@Header(KafkaHeaders.OFFSET) int offset, @Header(KafkaHeaders.RECEIVED_PARTITION) int part,
			@Payload Greeting in) {
		var message = Map.of("greeting", in, "partition", part, "offset", offset);
		log.info(message.toString());
	}

	@Bean
	NewTopic notifications() {
		return TopicBuilder.name(NOTIFICATIONS).partitions(1).replicas(1).build();
	}

	@Bean
	NewTopic greetings() {
		return TopicBuilder.name(GREETINGS).partitions(1).replicas(1).build();
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> greetingsRunner(KafkaTemplate<Object, Object> template) {
		return event -> template.send(GREETINGS, new Greeting("Hello, Kafka!"));
	}

}

record Greeting(String message) {
}

@Slf4j
@Configuration
class SpringIntegrationKafkaConfiguration {

	@Bean
	ApplicationListener<ApplicationReadyEvent> notificationsRunner(KafkaTemplate<Object, Object> template) {
		return event -> template.send(NOTIFICATIONS, new Greeting("This is a notification, mang!"));
	}

	@Bean
	ContainerProperties containerProperties() {
		var cp = new ContainerProperties(NOTIFICATIONS);
		cp.setGroupId(NOTIFICATIONS + "-group");
		return cp;
	}

	@Bean
	IntegrationFlow inboundFileOutboundKafkaIntegrationFlow(KafkaTemplate<Object, Object> kafkaTemplate,
			ObjectMapper objectMapper, @Value("file://${user.home}/Desktop/inbound") File inboundDirectory) {
		var files = Files //
				.inboundAdapter(inboundDirectory) //
				.autoCreateDirectory(true);
		var kafka = Kafka.outboundChannelAdapter(kafkaTemplate).topic(NOTIFICATIONS).get();
		return IntegrationFlow.from(files, spca -> spca.poller(pm -> pm.fixedRate(10_000)))
				.transform(new FileToStringTransformer())
				.transform((GenericTransformer<String, Greeting>) source -> Json.read(objectMapper, Greeting.class,
						source))
				.handle((GenericHandler<Greeting>) (payload, headers) -> {
					log.info("new file's contents: " + payload);
					return payload;
				}).handle(kafka).get();
	}

	@Bean
	IntegrationFlow inboundKafkaIntegrationFlow(ContainerProperties containerProperties,
			ConsumerFactory<Object, Object> consumerFactory) {
		var inboundKafka = Kafka//
				.messageDrivenChannelAdapter(consumerFactory, containerProperties) //
				.get();
		return IntegrationFlow.from(inboundKafka) //
				.handle((GenericHandler<Greeting>) (payload, headers) -> {
					var joinedKeys = String.join(",", headers.keySet());
					log.info("new greeting in the integration flow: " + payload + " with keys " + joinedKeys);
					return null;
				}) // l
				.get();
	}

}

abstract class Json {

	@SneakyThrows
	public static <T> T read(ObjectMapper objectMapper, Class<T> tClass, String json) {
		return objectMapper.readValue(json, tClass);
	}

	@SneakyThrows
	public static String write(ObjectMapper mapper, Object obj) {
		return mapper.writeValueAsString(obj);
	}

}