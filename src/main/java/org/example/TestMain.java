package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args)throws IOException  {

    }
    public static void writeToFileFromConsole() throws IOException{
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, write words : ");
        while (true) {
            String word = scanner.nextLine();
            if (!(word.equals("stop"))) {
                result= result+"\n"+word;
            } else {
                File file = new File("example.txt");
                PrintWriter pw = new PrintWriter(file);
                pw.println(result.trim());
                pw.close();
                break;
            }
        }
    }
    public static void printContent() throws IOException {
        String separator = File.separator;
        String path = separator + "Users" + separator + "Tornike" + separator + "Desktop" + separator + "ProdExpl" + separator + "example.txt ";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

}
