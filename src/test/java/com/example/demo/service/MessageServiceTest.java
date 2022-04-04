package com.example.demo.service;

import java.util.List;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Group;
import com.example.demo.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageServiceTest {

    private final MessageService messageService = new MessageService();

    @Test
    public void givenEvent_whenHandle_thenAddMessage() {
        User juan = new User(1, "Juan");
        User pedro = new User(2, "Pedro");
        User lucia = new User(3, "Lucia");
        Group techGroup = new Group("The tech boys", List.of(juan, pedro, lucia));
        String message = "This is a message";
        messageService.addMessage(techGroup, lucia, message);

        Awaitility.await().untilAsserted(() -> {
            assertEquals(1, juan.getMessages().size());
            assertEquals(1, pedro.getMessages().size());
            assertEquals(0, lucia.getMessages().size());
        });
    }
}
