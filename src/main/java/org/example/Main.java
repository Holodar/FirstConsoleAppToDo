package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static List<String> tasks = new ArrayList<>();




    public static void main(String[] args) throws IOException, ClassNotFoundException {

        startContent();

        while (true) {

            //Todo menu
            System.out.println("Menu");
            System.out.println("-----");
            System.out.println("1.My tasks");
            System.out.println("2.Create task");
            System.out.println("3.About the author");
            System.out.println("4.Delete your task");
            System.out.println("5.Exit");

            //Todo switch cases:
            Scanner scanner = new Scanner(System.in);
            System.out.print("Make a choice : ");
            try {

                int x = scanner.nextInt();
                String task = scanner.nextLine();
                System.out.println("----------------------------------");
                switch (x) {
                    case 1:
                        if(tasks.size() == 0){
                            System.out.println("You have no tasks, try to create them ");
                        }else{
                            System.out.println("You have "+ tasks.size()+" tasks");
                            for(int i = 0; i<tasks.size();i++){
                                System.out.println((i+1)+". "+tasks.get(i));
                            }
                    }
                        break;
                    case 2:
                        System.out.print("Create task name : ");
                        task = scanner.nextLine();
                        while (task.equals(" ") || task.equals("")) {
                            System.out.println("Your cant write empty task, try again !");
                            task = scanner.nextLine();
                            }
                        tasks.add(task);
                        saveContent();
                        System.out.println("zapis` nice");



                        break;
                    case 3:
                        System.out.println("Hello I`m Author Tornike, \n" +
                                "I teach Java but I can't write a banal code ");
                        break;

                    case 4:
                        System.out.println("Chose your task from delete : ");
                        for(int i =0 ; i<tasks.size();i++){
                            System.out.println((i+1)+". "+tasks.get(i));
                        }
                        System.out.print("Chose your task: ");
                        //x = scanner.nextInt();

                        while (x>tasks.size()|| x<0) {
                            x = scanner.nextInt();
                            System.out.println("You dont have that task number, try again! If you want back, write exit");
                            task = scanner.nextLine();
                            if(task.equals("exit")){
                                break;
                            }
                        }
                        for(int i =0 ; i<=tasks.size();i++){
                            if(x==i){
                                tasks.remove(i-1);
                                System.out.println("Delete successful");
                                saveContent();
                            }

                        }
                        break;
                    case 5:
                        System.out.println("i`m out MFuk !");
                        System.exit(0);
                    default:
                        System.out.println("Please enter a valid value.Noob");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must write numbers");
            }
            System.out.println("------------------------------------");

            //Todo create FileInPut



            //Todo create FileOutPut


        }
    }
        public static void startContent() throws  IOException{
            String separator = File.separator;
            String path = separator + "Users" + separator + "Tornike" + separator + "Desktop" + separator + "ProdExpl" + separator + "list.txt ";
            File file = new File(path);
            Scanner readerFile = new Scanner(file);
            while (readerFile.hasNext()) {
                tasks.add(readerFile.nextLine());
            }
            readerFile.close();
        }
        public static void saveContent() throws IOException{
            String joiner = String.join("\n",tasks);
            File fileOut = new File("list.txt");
            PrintWriter pw = new PrintWriter(fileOut);
            pw.println(joiner);
            pw.close();
        }
}
