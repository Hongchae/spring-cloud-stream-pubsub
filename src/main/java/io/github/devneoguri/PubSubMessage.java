package io.github.devneoguri;

import java.io.Serializable;

public class PubSubMessage implements Serializable {

    public PubSubMessage(String content) {
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + content + "]";
    }
}
