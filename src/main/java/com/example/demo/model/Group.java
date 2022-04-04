package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Group {
    private String name;
    private List<User> users;

}
