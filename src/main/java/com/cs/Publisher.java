package com.cs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class Publisher {

	@Autowired
    private Source source;
	
	@PostMapping
	public String sendMessage(@RequestBody TestMessage message) {
		source.output().send(MessageBuilder.withPayload(message).setHeader("routeTo", "blue").build());
		System.out.println(String.format("[Sent]: %s", message.getMessage()));
		return "success";
	}
}
