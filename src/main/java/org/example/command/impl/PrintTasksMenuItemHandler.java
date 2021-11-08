package org.example.command.impl;

import org.example.ToDoRepository;
import org.example.command.MenuItemHandler;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;


public class PrintTasksMenuItemHandler implements MenuItemHandler {
    private  ToDoRepository toDoRepository;
    public PrintTasksMenuItemHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void handle() throws IOException {

        List<String> tasks = toDoRepository.findAll();
        if (tasks.size() == 0) {
            System.out.println("You have no tasks, try to create them ");
        } else {
            System.out.println("You have " + tasks.size() + " tasks");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
