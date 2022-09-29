package com.example.analytics;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class AnalyticsApplication {

    static final String PAGE_COUNT_MV = "pcmv";

    public static void main(String[] args) {
        SpringApplication.run(AnalyticsApplication.class, args);
    }

    @Bean
    public Supplier<PageViewEvent> pageViewEventSupplier() {
        var names = List.of("mfisher", "dyser", "schacko", "abilan", "ozhurakousky", "grussell");
        var pages = List.of("blog", "sitemap", "initializr", "news", "colophon", "about");
        return () -> {
            var rPage = pages.get(new Random().nextInt(pages.size()));
            var rName = pages.get(new Random().nextInt(names.size()));
            return new PageViewEvent(rName, rPage, Math.random() > .5 ? 10 : 1000);
        };
    }

    @Bean
    public Function<KStream<String, PageViewEvent>, KStream<String, Long>> process() {
        return kStream -> kStream //
                .filter((key, value) -> value.duration() > 10) //
                .map((key, value) -> new KeyValue<>(value.page(), "0"))//
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String())) //
                .count(Materialized.as(AnalyticsApplication.PAGE_COUNT_MV))// wroxdb behind the scenes
                .toStream();
    }

    @Bean
    public Consumer<KTable<String, Long>> pageCount() {
        return counts -> counts.toStream().foreach((key, value) -> log.info(key + "=" + value));
    }
}

@Controller
@ResponseBody
class CountRestController {

    private final InteractiveQueryService iqs;

    CountRestController(InteractiveQueryService iqs) {
        this.iqs = iqs;
    }

    @GetMapping("/counts")
    Map<String, Long> counts() {
        ReadOnlyKeyValueStore<String, Long> queryableStoreType =
                this.iqs.getQueryableStore(AnalyticsApplication.PAGE_COUNT_MV, QueryableStoreTypes.keyValueStore());
        var counts = new HashMap<String, Long>();
        try (var all = queryableStoreType.all()) {
            while (all.hasNext()) {
                var value = all.next();
                counts.put(value.key, value.value);
            }
        }
        return counts;
    }
}

record PageViewEvent(String userId, String page, long duration) {
}