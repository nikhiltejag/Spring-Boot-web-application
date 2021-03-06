package com.in28minutes.springbootfirstwebapplication.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in28minutes.springbootfirstwebapplication.model.Todo;

import org.springframework.stereotype.Component;

@Component
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<>();

        for (Todo each : todos) {
            if (each.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(each);
            }
        }

        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo item : todos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todos.add(new Todo(++todosCount, name, desc, targetDate, isDone));
    }

    public void updateTodo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();

        while (iterator.hasNext()) {
            Todo todo = iterator.next();

            if (todo.getId() == id)
                iterator.remove();
        }
    }
}
