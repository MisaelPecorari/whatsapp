package com.example.demo.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.MessageEvent;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Publish-subscribe pattern must be applied using Kafka as messaging broker.
 * I decided to use Spring Events to achieve the activity goal in the given time.
 */
@Service
@Slf4j
@AllArgsConstructor
public class MessageListener {

    private final MessageService messageService;

    @EventListener
    public void handleMessageEvent(MessageEvent event) {
        Group group = event.getDestination();
        User senderUser = event.getSender();
        String message = event.getMessage();
        log.info("[{}] {}: {}", group.getName(), senderUser.getName(), message);
        messageService.addMessage(group, senderUser, message);
    }
}
