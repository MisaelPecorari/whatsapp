package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Group;
import com.example.demo.model.MessageEvent;
import com.example.demo.model.User;

@ExtendWith(MockitoExtension.class)
public class MessageListenerTest {

    @InjectMocks
    private MessageListener messageListener;
    @Mock
    private MessageService messageService;

    @Test
    public void givenEvent_whenHandle_thenAddMessage() {
        User juan = new User(1, "Juan");
        User pedro = new User(2, "Pedro");
        Group techGroup = new Group("The tech boys", List.of(juan, pedro));
        String message = "This is a message";
        MessageEvent event = new MessageEvent(this, juan, message, techGroup);

        messageListener.handleMessageEvent(event);
        Mockito.verify(messageService, Mockito.times(1)).addMessage(techGroup, juan, message);
    }

}