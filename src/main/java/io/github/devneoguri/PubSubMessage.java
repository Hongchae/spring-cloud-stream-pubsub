package io.github.devneoguri;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;

public class PubSubMessage implements Message {
    private MessageHeaders headers;
    private String payload;

    public PubSubMessage(MessageHeaders headers, String payload) {
        this.headers = headers;
        this.payload = payload;
    }

    public PubSubMessage(String payload) {
        this.payload = payload;
    }

    @Override
    public Object getPayload() {
        return payload;
    }

    @Override
    public MessageHeaders getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "[" + payload + "]";
    }
}
