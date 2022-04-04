package com.example.demo.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.GroupMessage;
import com.example.demo.model.MessageEvent;
import com.example.demo.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Publish-subscribe pattern must be applied using Kafka as messaging broker.
 * I decided to use Spring Events to achieve the activity goal in the given time.
 */
@Service
@Slf4j
public class MessageListener {

    @EventListener
    public void handleMessageEvent(MessageEvent event) {
        Group group = event.getDestination();
        User senderUser = event.getSender();
        String message = event.getMessage();
        log.info("[{}] {}: {}", group.getName(), senderUser.getName(), message);
        addMessage(group, senderUser, message);
    }

    private void addMessage(Group group, User senderUser, String message) {
        group.getUsers().forEach(user -> {
            if (user.getId() != senderUser.getId()) {
                GroupMessage newMessage = new GroupMessage(group.getName(), senderUser.getName(), message);
                user.addMessage(newMessage);
            }
        });
    }
}
