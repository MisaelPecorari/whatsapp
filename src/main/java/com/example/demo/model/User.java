package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private List<GroupMessage> messages;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void addMessage(GroupMessage groupMessage) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(groupMessage);
    }

}
