package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GroupMessage {
    private String groupName;
    private String userName;
    private String message;
}
