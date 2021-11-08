package org.example.command.impl;

import org.example.ToDoRepository;
import org.example.command.MenuItemHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class DeleteTaskItemHandler implements MenuItemHandler {

    private ToDoRepository toDoRepository;
    public DeleteTaskItemHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void handle() throws IOException {
        List<String> tasks = toDoRepository.findAll();

        System.out.println("Chose your task from delete : ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.print("Chose your task: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        while (x > tasks.size() || x < 0) {
            x = scanner.nextInt();
            System.out.println("You dont have that task number, try again! If you want back, write exit");

            String task = scanner.nextLine();
            if (task.equals("exit")) {
                break;
            }
        }
        for (int i = 0; i <= tasks.size(); i++) {
            if (x == i) {
                tasks.remove(i - 1);
                toDoRepository.save(tasks);
                System.out.println("Delete successful");
            }
        }
    }
}
