package com.example.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
/*

@Configuration
class KafkaConfiguration {

    @Bean
    NewTopic pageCountsTopic() {
        return new NewTopic("page_counts", 1, (short) 1);
    }
}
*/

@Slf4j
@Configuration
class PageViewAnalyticsConfiguration {


    static final String PAGE_COUNT_MV = "pcmv";


    @Bean
    Function<KStream<String, PageViewEvent>, KStream<String, Long>> process( ) {
        return kStream -> kStream //
                //.mapValues(s -> read(objectMapper, s, PageViewEvent.class))
                .filter((key, value) -> value.duration() > 10) //
                .map((key, value) -> new KeyValue<>(value.page(), "0"))//
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String())) //
                .count(Materialized.as(PageViewAnalyticsConfiguration.PAGE_COUNT_MV))// rocksdb behind the scenes
                .toStream();
    }

    @Bean
    Consumer<KTable<String, Long>> pageCount() {
        return counts -> counts.toStream().foreach((key, value) -> log.info(key + "=" + value));
    }

}

record PageViewEvent(String userId, String page, long duration) {
}