package io.github.devneoguri;

import io.github.devneoguri.config.StreamPubSubConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableBinding(Processor.class)
@Import({StreamPubSubConfig.class})
public class SpringCloudStreamPubSubApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamPubSubApplication.class, args);
	}
}
