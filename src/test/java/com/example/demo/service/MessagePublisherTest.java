package com.example.demo.service;

import java.util.List;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Group;
import com.example.demo.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessagePublisherTest {

    @Autowired
    private MessagePublisher messagePublisher;

    @Test
    public void givenGroup_whenSendMessage_thenGroupMembersGetIt() {
        User juan = new User(1, "Juan");
        User pedro = new User(2, "Pedro");
        User lucia = new User(3, "Lucia");

        Group techGroup = new Group("The tech boys", List.of(juan, pedro, lucia));
        messagePublisher.sendMessage(lucia, "Hi! How are you?", techGroup);

        Awaitility.await().untilAsserted(() -> {
            assertEquals(1, juan.getMessages().size());
            assertEquals(1, pedro.getMessages().size());
            assertEquals(0, lucia.getMessages().size());
        });

        Group footballTeam = new Group("Let's do a match!", List.of(juan, pedro));
        messagePublisher.sendMessage(pedro, "Let's match tonight!", footballTeam);
        Awaitility.await().untilAsserted(() -> {
            assertEquals(2, juan.getMessages().size());
            assertEquals(1, pedro.getMessages().size());
            assertEquals(0, lucia.getMessages().size());
        });
    }

}