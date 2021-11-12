package org.example.command.impl;

import com.google.common.collect.ImmutableMap;
import org.example.ToDoRepository;
import org.example.command.MenuItemHandler;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;


public class ItemHandlerCommadContainer {
    private final Map<Integer, MenuItemHandler> commandsMap;
    private final ToDoRepository toDoRepository = new ToDoRepository("C:\\Users\\Tornike\\Desktop\\ProdExpl\\xxxx.txt");

    public ItemHandlerCommadContainer() {
        this.commandsMap = ImmutableMap.of(
                1, new PrintTasksMenuItemHandler(toDoRepository),
                2, new CreateTaskItemHandler(toDoRepository),
                3, new AboutAuthorHandler(),
                4, new DeleteTaskItemHandler(toDoRepository),
                5, new ExitTaskHandler()
        );

    }

    public void execute(int x) {

        try {
            MenuItemHandler handler = commandsMap.get(x);
            if (handler != null) {
                handler.handle();
            } else {
                System.err.println("Будьте добры введите корректное число!");
            }
        } catch (InputMismatchException | IOException e) {
            System.err.println("You must write numbers");
        }
    }
}

