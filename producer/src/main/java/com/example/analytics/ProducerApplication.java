package com.example.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.GenericMessage;
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


@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }


    @KafkaListener(
            //  properties = "value.deserializer=org.springframework.kafka.support.serializer.JsonDeserializer" ,
            groupId = "page_views_group", topics = "page_views")
    public void consume(String pageViewEvent) {
        System.out.println("got it from the @KafkaListener " + pageViewEvent);
    }


    @Bean
    Consumer<PageViewEvent> test() {
        return c -> System.out.println("GOT IT -- " + c);
    }
}

@Configuration
class KafkaConfiguration {

    @Bean
    NewTopic pageViewsTopic() {
        return new NewTopic("page_views", 1, (short) 1);
    }
}

@Controller
@ResponseBody
class ViewController {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper;

    @Autowired
    @Lazy
    KafkaTemplate<String, String> myKafkaTemplate;

    @Autowired
    ConfigurableApplicationContext context;

    ViewController(StreamBridge streamBridge, ObjectMapper objectMapper) {
        this.streamBridge = streamBridge;
        this.objectMapper = objectMapper;
    }

    @Bean
    public KafkaTemplate<String, String> myKafkaTemplate(ProducerFactory<String, String> pf) {
        return new KafkaTemplate<>(pf,
                Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class));
    }

    @ServiceActivator(inputChannel = "toKafka")
    @Bean
    public MessageHandler handler(KafkaTemplate<String, String> myKafkaTemplate) {
        return new KafkaProducerMessageHandler<>(myKafkaTemplate);
    }

    @SneakyThrows
    private String json(Object o) {
        return this.objectMapper.writeValueAsString(o);
    }

    @GetMapping("/view")
    Map<String, String> counts() {
        var pageViewEvent = json(random());
        var sent = this.streamBridge.send(
                "pageViewEvent-out-0", pageViewEvent);
        Assert.state(sent, "the " + pageViewEvent + " has not been sent");
        return Map.of("message", pageViewEvent);
    }

    @GetMapping("/view1")
    Map<String, String> counts1() throws ExecutionException, InterruptedException {
        var pageViewEvent = json(random());
        var sent = myKafkaTemplate.send("page_views", pageViewEvent);
        sent.get();
        Assert.state(sent.isDone(), "the " + pageViewEvent + " has not been sent");
        return Map.of("message", pageViewEvent);
    }

    @GetMapping("/view2")
    Map<String, String> counts2() throws ExecutionException, InterruptedException {
        var pageViewEvent = json(random());

        Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, "page_views");

        MessageChannel toKafka = context.getBean("toKafka", MessageChannel.class);

        final boolean send = toKafka.send(new GenericMessage<>(pageViewEvent, headers));

        Assert.state(send, "the " + pageViewEvent + " has not been sent");
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
