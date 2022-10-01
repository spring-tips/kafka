package com.example.analytics;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * AOT doesn't support generics for things like {@link KafkaTemplate } and {@link  ProducerFactory}
 */

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @KafkaListener(
            groupId = "page_views_group", topics = "page_views")
    public void consume(PageViewEvent json) {
        System.out.println("got it from the @KafkaListener " + json);
    }

    @Bean
    Consumer<PageViewEvent> test() {
        return c -> System.out.println("GOT IT -- " + c);
    }
}

@Configuration
class KafkaConfiguration {

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    NewTopic pageViewsTopic() {
        return new NewTopic("page_views", 1, (short) 1);
    }

    @Bean
    KafkaTemplate<Object, Object> myKafkaTemplate(ProducerFactory<Object, Object> pf) {
        return new KafkaTemplate<>(pf,
                Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class));
    }

}

@Configuration
class IntegrationConfiguration {

    @Bean
    MessageChannel toKafka() {
        return MessageChannels.direct().get();
    }

    @Bean
    IntegrationFlow outboundKafkaFlow(MessageChannel toKafka, KafkaTemplate<Object, Object> pageViewEventKafkaTemplate) {
        var kafkaOutboundAdapter = Kafka
                .outboundChannelAdapter(pageViewEventKafkaTemplate)
                .get();
        return IntegrationFlow
                .from(toKafka)
                .handle(kafkaOutboundAdapter)
                .get();
    }

}

@Controller
@ResponseBody
class ViewController {

    private final StreamBridge streamBridge;
    private final KafkaTemplate<Object, Object> myKafkaTemplate;
    private final MessageChannel toKafka;

    ViewController(KafkaTemplate<Object,Object> myKafkaTemplate, MessageChannel toKafka, StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
        this.toKafka = toKafka;
        this.myKafkaTemplate = myKafkaTemplate;
    }

    @GetMapping("/view")
    Map<String, PageViewEvent> counts() {
        var pageViewEvent = random();
        var sent = this.streamBridge.send("pageViewEvent-out-0", pageViewEvent);
        Assert.state(sent, "the " + pageViewEvent + " has not been sent");
        return Map.of("message", pageViewEvent);
    }

    @GetMapping("/view1")
    Map<String, PageViewEvent> counts1() throws ExecutionException, InterruptedException {
        var pageViewEvent = random();
        myKafkaTemplate.send("page_views", pageViewEvent).get();
        return Map.of("message", pageViewEvent);
    }

    @GetMapping("/view2")
    Map<String, PageViewEvent> counts2() throws ExecutionException, InterruptedException {
        var pageViewEvent = random();
        var headers = Map.of(KafkaHeaders.TOPIC, "page_views");
        toKafka.send(MessageBuilder.withPayload(pageViewEvent).copyHeaders(headers).build());
        return Map.of("message", pageViewEvent);
    }

    private PageViewEvent random() {
        var names = List.of("mfisher", "dyser", "schacko", "abilan", "ozhurakousky", "grussell");
        var pages = List.of("blog", "sitemap", "initializr", "news", "colophon", "about");
        var rPage = pages.get(new Random().nextInt(pages.size()));
        var rName = pages.get(new Random().nextInt(names.size()));
        return new PageViewEvent(rName, rPage, Math.random() > .5 ? 10 : 1000);
    }
}

record PageViewEvent(String userId, String page, long duration) {
}
