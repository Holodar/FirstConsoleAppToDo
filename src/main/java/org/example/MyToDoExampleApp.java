package org.example;

import org.example.command.impl.*;

import java.util.Scanner;


public class MyToDoExampleApp {
    private final ItemHandlerCommadContainer itemHandlerCommadContainer = new ItemHandlerCommadContainer();

    public void run() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Make a choice : ");
            int x = scanner.nextInt();
            itemHandlerCommadContainer.execute(x);
        }
    }

    public void printMenu() {
        System.out.println("Menu");
        System.out.println("-----");
        System.out.println("1.My tasks");
        System.out.println("2.Create task");
        System.out.println("3.About the author");
        System.out.println("4.Delete your task");
        System.out.println("5.Exit");
    }

}
