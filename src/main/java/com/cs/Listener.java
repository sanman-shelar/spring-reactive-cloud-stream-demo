package com.cs;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class Listener {

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
    public TestMessage enrichLogMessage(TestMessage message) {
		System.out.println(message.getMessage());
        return new TestMessage(String.format("[1]: %s", message.getMessage()));
    }
}
