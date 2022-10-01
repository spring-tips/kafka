package com.example.analytics;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
* AOT doesn't support generics for things like {@link KafkaTemplate } and
* {@link ProducerFactory}
*/
@SpringBootApplication
public class ProducerApplication {

public static void main(String[] args) {
SpringApplication.run(ProducerApplication.class, args);
}
}

@Configuration
class KafkaConfiguration {

@Bean
JsonMessageConverter jsonMessageConverter() {
return new JsonMessageConverter();
}

@Bean
NewTopic pageViewTopic() {
return new NewTopic("page_views", 1, (short) 1);
}

@Bean
KafkaTemplate<Object, Object> kafkaTemplate(ProducerFactory<Object, Object> pf) {
return new KafkaTemplate<>(pf, Map.of(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class));
}

@KafkaListener(groupId = "page_views_group", topics = "page_views")
public void pageViewsKafkaListener( //
@Header(KafkaHeaders.OFFSET) int offset, //
@Header(KafkaHeaders.RECEIVED_PARTITION) int partition, //
@Payload PageViewEvent pageViewEvent, Acknowledgment acknowledgment) {
System.out.println("@KafkaListener(" + offset + "," + partition + "): " + pageViewEvent);
acknowledgment.acknowledge();
}
}

@Configuration
class IntegrationConfiguration {

@Bean
MessageChannel kafkaMessageChannel() {
return MessageChannels.direct().get();
}

@Bean
IntegrationFlow outboundKafkaFlow(MessageChannel kafkaMessageChannel,
KafkaTemplate<Object, Object> pageViewEventKafkaTemplate) {
var kafkaOutboundAdapter = Kafka.outboundChannelAdapter(pageViewEventKafkaTemplate).get();
return IntegrationFlow.from(kafkaMessageChannel).handle(kafkaOutboundAdapter).get();
}

}

@Configuration
class StreamConfiguraton {

@Bean
Consumer<PageViewEvent> consumer() {
return pageViewEvent -> System.out.println("Consumer<T>: " + pageViewEvent);
}

}

@Controller
@ResponseBody
@RequiredArgsConstructor
class RunnerConfiguration {

@Bean
ApplicationListener<ApplicationReadyEvent> runner(KafkaTemplate<Object, Object> template,
MessageChannel kafkaMessageChannel, StreamBridge streamBridge) {
return event -> Executors.newScheduledThreadPool(1).schedule(() -> {
for (var i = 0; i < 100; i++) {
template(template);
integration(kafkaMessageChannel);
stream(streamBridge);
}
}, 2, TimeUnit.SECONDS);
}

@SneakyThrows
private static void template(KafkaTemplate<Object, Object> template) {
template.send("page_views", random()).get();
}

@SneakyThrows
private static void stream(StreamBridge streamBridge) {
streamBridge.send("pageViews-out-0", random());
}

@SneakyThrows
private static void integration(MessageChannel channel) {
var headers = Map.of(KafkaHeaders.TOPIC, "page_views");
var message = MessageBuilder.withPayload(random()).copyHeaders(headers).build();
channel.send(message);
}

private static PageViewEvent random() {
int duration = Math.random() > .5 ? 10 : 1000;
var names = List.of("josh", "dave", "yuxin", "olga", "violetta", "madhura", "olivier", "grussell", "sobe");
var pages = List.of("blog", "sitemap", "initializr", "news", "colophon", "about");
var rPage = pages.get(new Random().nextInt(pages.size()));
var rName = names.get(new Random().nextInt(names.size()));
return new PageViewEvent(rName, rPage, duration);
}
}

record PageViewEvent(String userId, String page, long duration) {
}
