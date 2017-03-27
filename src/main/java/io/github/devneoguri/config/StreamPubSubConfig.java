package io.github.devneoguri.config;

import io.github.devneoguri.PubSubController;
import io.github.devneoguri.pubsub.PubSub;
import io.github.devneoguri.pubsub.StreamPubSubImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamPubSubConfig {

    @Autowired
    Processor processor;

    @Bean
    PubSub pubSub() {
        StreamPubSubImpl bean = new StreamPubSubImpl();
        bean.setProcessor(processor);
        return bean;
    }

    @Bean
    PubSubController pubSubController() {
        PubSubController bean = new PubSubController();
        bean.setPubsub(pubSub());
        return bean;
    }
}
