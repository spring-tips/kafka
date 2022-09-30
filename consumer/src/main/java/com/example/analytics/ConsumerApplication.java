package com.example.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Configuration
class PageViewAnalyticsConfiguration {


    static final String PAGE_COUNT_MV = "pcmv";

    @SneakyThrows
    private <T> T read(ObjectMapper objectMapper, String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }

    @Bean
    Function<KStream<String, String>, KStream<String, Long>> process(ObjectMapper objectMapper) {
        return kStream -> kStream //
                .mapValues(s -> read(objectMapper, s, PageViewEvent.class))
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