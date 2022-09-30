package com.example.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;


@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}

@Controller
@ResponseBody
class ViewController {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper ;

    ViewController(StreamBridge streamBridge, ObjectMapper objectMapper) {
        this.streamBridge = streamBridge;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    private String json (Object o) {
        return this.objectMapper.writeValueAsString(o ) ;
    }
    @GetMapping("/view")
    Map<String, String> counts() {
        var pageViewEvent = json (  random());
        var sent = this.streamBridge.send(
                "pageViewEvent-out-0", pageViewEvent);
        Assert.state(sent, "the " + pageViewEvent + " has not been sent");
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