package com.example.analytics;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
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
import org.springframework.integration.util.StackTraceUtils;
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
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * AOT doesn't support generics for things like {@link KafkaTemplate } and {@link  ProducerFactory}
 */

@SpringBootApplication
public class ProducerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @KafkaListener(groupId = "page_views_group", topics = "page_views")
    public void consume(
            @Header(KafkaHeaders.OFFSET) int offset,//
            @Header(KafkaHeaders.RECEIVED_PARTITION) int part,//
            @Payload PageViewEvent pageViewEvent, Acknowledgment acknowledgment) {
        System.out.println("@KafkaListener(" + offset + "," + part + "): " + pageViewEvent);
        acknowledgment.acknowledge();
    }

    @Bean
    Consumer<PageViewEvent> consumer() {
        return pageViewEvent -> System.out.println("Consumer<T>: " + pageViewEvent);
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
    KafkaTemplate<Object, Object> myKafkaTemplate(ProducerFactory<Object, Object> pf) {
        return new KafkaTemplate<>(pf, Map.of(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class));
    }

}

@Configuration
class TransactionConfiguration {

    @Bean
    BeanPostProcessor transactionBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof KafkaTemplate<?, ?> kafkaTemplate) {
                    System.out.println("setAllowNonTransactional=true");
                    kafkaTemplate.setAllowNonTransactional(true);
                }
                return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }
        };
    }

  /*  @Bean
    InitializingBean transactionalKafkaTemplateInitializingBean(KafkaTemplate<Object, Object> template) {
        return () -> template.setAllowNonTransactional(true);
    }*/
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
        var kafkaOutboundAdapter = Kafka
                .outboundChannelAdapter(pageViewEventKafkaTemplate)
                .get();
        return IntegrationFlow
                .from(kafkaMessageChannel)
                .handle(kafkaOutboundAdapter)
                .get();
    }

}

@Controller
@ResponseBody
@RequiredArgsConstructor
class RunnerConfiguration {

    @Bean
    ApplicationListener<ApplicationReadyEvent> runner (
            KafkaTemplate<Object, Object> template,
            MessageChannel kafkaMessageChannel,
            StreamBridge streamBridge,
            TransactionTemplate tx ) {
        return event -> Executors.newScheduledThreadPool(1).schedule(() -> {
//            template(template);
//            integration(kafkaMessageChannel);
//            stream(streamBridge);
            tx(tx, template);
        }, 2, TimeUnit.SECONDS);
    }

    @SneakyThrows
    private static void tx(TransactionTemplate transactionTemplate, KafkaTemplate<Object, Object> template) {
        var messages = new ArrayList<PageViewEvent>();
        for (var i = 0; i < 10; i++)
            messages.add(random());
        txSend(transactionTemplate, template, true, messages);
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
        var message = MessageBuilder
                .withPayload(random())
                .copyHeaders(headers)
                .build();
        channel.send(message);
    }

    private static void txSend(TransactionTemplate transactionTemplate,
                               KafkaTemplate<Object, Object> kafkaTemplate, boolean fail, Collection<?> messages) {
        transactionTemplate.execute(status -> {
            for (var m : messages) {
                try {
                    kafkaTemplate.send("page_views", m) .get();
                } //
                catch (Exception e) {
                    System.out.println("oops!"  + e.getMessage());
                }
            }
            if (fail) throw new IllegalArgumentException("this shouldn't work!");
            return true;
        });
    }

    private static PageViewEvent random(int duration) {
        var names = List.of("josh", "dave", "yuxin", "olga", "violetta",
                "madhura", "olivier", "grussell", "sobe");
        var pages = List.of("blog", "sitemap",
                "initializr", "news", "colophon", "about");
        var rPage = pages.get(new Random().nextInt(pages.size()));
        var rName = names.get(new Random().nextInt(names.size()));
        return new PageViewEvent(rName, rPage, duration);
    }

    private static PageViewEvent random() {
        return random(Math.random() > .5 ? 10 : 1000);
    }
}

record PageViewEvent(String userId, String page, long duration) {
}
