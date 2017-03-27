package io.github.devneoguri;

import io.github.devneoguri.pubsub.PubSub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {
    private Logger logger = LoggerFactory.getLogger(PubSubController.class);

    private PubSub pubsub;

    public void setPubsub(PubSub pubsub) {
        this.pubsub = pubsub;

        pubsub.subscribe(m -> logger.info("> message consumed 1: {}", m));

        pubsub.subscribe(m -> logger.info("> message consumed 2: {}", m));
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public void publish(@RequestParam String content) {
        final PubSubMessage pubSubMessage = new PubSubMessage(content);
        pubsub.publish(MessageBuilder.withPayload(pubSubMessage).build());
    }
}
