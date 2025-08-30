package com.khan.learn_spring_security.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TodoController {
    private static final List<Todo> TODO_LIST = new ArrayList<>(Arrays.asList(new Todo("bashar", "Learn Aws"),
            new Todo("noor", "Learn Spring Security"),
            new Todo("noor", "Learn Driving")));

    @GetMapping("/todos")
    public List<Todo> findAllTodos() {
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> findAllTodosByUser(@PathVariable String username) {
        return TODO_LIST.stream().filter(todo -> todo.username().equalsIgnoreCase(username)).toList();
    }

    @PostMapping("/todos")
    public boolean addTodo(@RequestBody Todo todo) {
        return TODO_LIST.add(todo);
    }
}

record Todo(String username, String description) {
}