package com.cs;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class Subscriber {

	@StreamListener(Sink.INPUT)
    public void logMessage(TestMessage message) {		
		System.out.println(String.format("[Received]: %s", message.getMessage()));
    }
}
