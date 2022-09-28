package bootiful;

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

@SpringBootApplication
public class SpringIntegrationKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationKafkaApplication.class, args);
    }
}

@Configuration
class KafkaConfiguration {

    final static String TOPIC = "greetings";

    @KafkaListener(id = TOPIC, topics = TOPIC)
    public void listen(Greeting in) {
        System.out.println("greeting: " + in);
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
