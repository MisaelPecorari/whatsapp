package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.GroupMessage;
import com.example.demo.model.User;

@Service
public class MessageService {

    public void addMessage(Group group, User senderUser, String message) {
        group.getUsers().forEach(user -> {
            if (user.getId() != senderUser.getId()) {
                GroupMessage newMessage = new GroupMessage(group.getName(), senderUser.getName(), message);
                user.addMessage(newMessage);
            }
            /*
            after this operation we could save the information to the database
             */
        });
    }

}
