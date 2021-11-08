package org.example;

import com.google.common.collect.ImmutableMap;
import org.example.command.MenuItemHandler;
import org.example.command.impl.*;

import java.io.IOException;
import java.util.*;

public class MyToDoExampleApp {

        public ToDoRepository toDoRepository = new ToDoRepository("C:\\Users\\Tornike\\Desktop\\ProdExpl\\xxxx.txt");
//public ToDoRepository toDoRepository = new FileToDoRepository("C:\\Users\\Tornike\\Desktop\\ProdExpl\\xxxx.txt");
//    public ToDoRepository toDoRepository = new InMemoryToDoRepository();

    Map<Integer, MenuItemHandler> commands = ImmutableMap.of(
            1, new PrintTasksMenuItemHandler(toDoRepository),
            2, new CreateTaskItemHandler(toDoRepository),
            3, new AboutAuthorHandler(),
            4, new DeleteTaskItemHandler(toDoRepository),
            5, new ExitTaskHandler()
    );

    public  void toDoWhileWork () throws IOException{
        while (true){
            printMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Make a choice : ");
            int x = -1;
            try {
                x = scanner.nextInt();
                MenuItemHandler handler = commands.get(x);
                if (handler != null) {
                    handler.handle();
                } else {
                    System.err.println("Будьте добры введите корректное число!");
                }
            } catch (InputMismatchException e) {
                System.err.println("You must write numbers");
            }
        }
    }


    public void printMenu(){
        System.out.println("Menu");
        System.out.println("-----");
        System.out.println("1.My tasks");
        System.out.println("2.Create task");
        System.out.println("3.About the author");
        System.out.println("4.Delete your task");
        System.out.println("5.Exit");
    }

}
