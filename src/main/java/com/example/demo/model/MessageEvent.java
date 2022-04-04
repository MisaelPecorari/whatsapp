package com.example.demo.model;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class MessageEvent extends ApplicationEvent {
    private final User sender;
    private final String message;
    private final Group destination;

    public MessageEvent(Object source, User sender, String message, Group destination) {
        super(source);
        this.sender = sender;
        this.message = message;
        this.destination = destination;
    }
}
