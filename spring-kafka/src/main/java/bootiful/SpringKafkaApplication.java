package bootiful;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

}

@Slf4j
@Configuration
class SpringKafkaConfiguration {

	final static String TOPIC = "greetings";

	@KafkaListener(id = TOPIC, topics = TOPIC)
	public void listen(@Header(KafkaHeaders.OFFSET) int offset, @Header(KafkaHeaders.RECEIVED_PARTITION) int part,
			@Payload Greeting in) {
		var message = Map.of("greeting", in, "partition", part, "offset", offset);
		log.info(message.toString());
	}

	@Bean
	NewTopic topic() {
		return TopicBuilder.name(TOPIC).partitions(1).replicas(1).build();
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> runner(KafkaTemplate<Object, Object> template) {
		return event -> template.send(TOPIC, new Greeting("Hello, Kafka!"));
	}

}

record Greeting(String message) {
}
