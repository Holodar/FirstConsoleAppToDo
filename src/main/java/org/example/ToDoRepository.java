package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ToDoRepository {
    private String path;

    public ToDoRepository(String path) {
        this.path = path;
    }

    public List<String> findAll() throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            return list;
        }
        Scanner readerFile = new Scanner(file);
        while (readerFile.hasNext()) {
            list.add(readerFile.nextLine());
        }
        readerFile.close();
        return list;
    }

    public void save(List<String> list) throws IOException {
        String joiner = String.join("\n", list);
        File fileOut = new File(path);
        PrintWriter pw = new PrintWriter(fileOut);
        pw.println(joiner);
        pw.close();
    }

    public void create(String task) throws IOException {
        List<String> list = findAll();
        list.add(task);
        save(list);
    }
}
