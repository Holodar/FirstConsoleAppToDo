package org.example.command.impl;

import org.example.command.MenuItemHandler;

public class AboutAuthorHandler implements MenuItemHandler {
    @Override
    public void handle() {
        System.out.println("Hello I`m Author Tornike, \n" +
                "I teach Java but I can't write a banal code ");
    }
}
