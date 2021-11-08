package org.example.command.impl;

import org.example.ToDoRepository;
import org.example.command.MenuItemHandler;

import java.io.IOException;
import java.util.Scanner;


public class CreateTaskItemHandler implements MenuItemHandler {

    private ToDoRepository toDoRepository;
    public CreateTaskItemHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void handle() throws IOException {
        System.out.print("Create task name : ");
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        while (task.equals(" ") || task.equals("")) {
            System.out.println("Your cant write empty task, try again !");
            task = scanner.nextLine();
        }

        toDoRepository.create(task);
        System.out.println("zapis` nice");
    }
}
