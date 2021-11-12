package org.example.command.impl;

import org.example.command.MenuItemHandler;

public class ExitTaskHandler implements MenuItemHandler {
    @Override
    public void handle() {
        System.out.println("i`m out MFuk !");
        System.exit(0);
    }
}
