package com.example.demo.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.MessageEvent;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;

/**
 * Publish-subscribe pattern must be applied using Kafka as messaging broker.
 * I decided to use Spring Events to achieve the activity goal in the given time.
 */
@Service
@AllArgsConstructor
public class MessagePublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void sendMessage(final User sender, final String message, final Group group) {
        ApplicationEvent messageEvent = new MessageEvent(this, sender, message, group);
        applicationEventPublisher.publishEvent(messageEvent);
    }

}
