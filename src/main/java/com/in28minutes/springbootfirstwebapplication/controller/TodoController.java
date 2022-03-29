package com.in28minutes.springbootfirstwebapplication.controller;

import com.in28minutes.springbootfirstwebapplication.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @Autowired
    static TodoService todoService;

    @RequestMapping("/todos-list")
    public static String listAllTodos(ModelMap model) {
        model.put("todos", todoService.retrieveTodos("in28Minutes"));
        return "todos-list";
    }
}
