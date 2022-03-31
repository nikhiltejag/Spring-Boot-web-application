package com.in28minutes.springbootfirstwebapplication.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.in28minutes.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springbootfirstwebapplication.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        return "list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model) {
        model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default desc", new Date(), false));
        return "add-todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "add-todo";
        }
        todoService.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.retrieveTodo(id);
        model.addAttribute("todo", todo);
        return "add-todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors())
            return "add-todo";
        todo.setUser((String) model.get("name"));

        List<Todo> todos = todoService.retrieveTodos((String) model.get("name"));

        for (Todo each : todos)
            System.out.println(todo + "\t" + each + "\n" + each.equals(todo));

        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
