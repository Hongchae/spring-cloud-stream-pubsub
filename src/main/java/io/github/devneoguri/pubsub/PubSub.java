package io.github.devneoguri.pubsub;

import io.github.devneoguri.PubSubMessage;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

public interface PubSub {
    void publish(Message<?> message);

    void subscribe(Consumer<PubSubMessage> callback);
}
