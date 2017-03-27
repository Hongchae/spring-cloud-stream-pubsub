package io.github.devneoguri.pubsub;

import io.github.devneoguri.PubSubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class StreamPubSubImpl implements PubSub {
    private Logger logger = LoggerFactory.getLogger(StreamPubSubImpl.class);

    private Processor processor;

    private List<Consumer<PubSubMessage>> callbackList = new ArrayList<>();

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void publish(Message<?> message) {
        processor.output().send(message);
        logger.info("> message published: {}", message);
    }

    @Override
    public void subscribe(Consumer<PubSubMessage> callback) {
        this.callbackList.add(callback);
    }

    @StreamListener(Processor.INPUT)
    public void listen(PubSubMessage message) {
        logger.info("< message received: {}", message);
        callbackList.forEach(c -> c.accept(message));
    }
}
