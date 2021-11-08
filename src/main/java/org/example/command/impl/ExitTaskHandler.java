package org.example.command.impl;

import org.example.command.MenuItemHandler;

import java.io.IOException;

public class ExitTaskHandler implements MenuItemHandler {
    @Override
    public void handle() throws IOException {
        System.out.println("i`m out MFuk !");
        System.exit(0);
    }
}
