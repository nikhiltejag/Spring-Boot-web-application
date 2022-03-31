package com.in28minutes.springbootfirstwebapplication.controller;

import java.util.Date;

import com.in28minutes.springbootfirstwebapplication.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String name = (String) model.get("name");
        model.put("todos", todoService.retrieveTodos(name));
        return "todos-list";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodo() {
        return "add-todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@RequestParam String desc, ModelMap model) {

        todoService.addTodo((String) model.get("name"), desc, new Date(), false);
        return "redirect:/list-todos";
    }
}
