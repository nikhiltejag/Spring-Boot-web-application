package com.in28minutes.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import com.in28minutes.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springbootfirstwebapplication.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService todoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String name = getLoggedInUsername(model);
        model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model) {
        model.addAttribute("todo", new Todo(0, getLoggedInUsername(model), "Default desc", new Date(), false));
        return "add-todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "add-todo";
        }
        todoService.addTodo(getLoggedInUsername(model), todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
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
        todo.setUser(getLoggedInUsername(model));

        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
