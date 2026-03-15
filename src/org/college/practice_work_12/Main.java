package org.college.practice_work_12;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "src/org/college/practice_work_12/text.txt";
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        boolean isRun = true;

        while(isRun){
            printMenu();
            String choise = sc.nextLine();
            switch(choise){
                case "1": WriteToFile(); break;
                case "2": ReadTheFile(); break;
                case "3": System.out.println("Вихід з програми..."); return;
                default: System.out.println("Помилка: Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printMenu(){
        System.out.println("\n--- МЕНЮ РЕДАКТОРА ---");
        System.out.println("1. Записати до файлу");
        System.out.println("2. Прочитати вміст файлу");
        System.out.println("3. Вийти з редактора");
        System.out.print("Оберіть дію: ");
    }

    private static void WriteToFile() throws IOException {
        System.out.println("Введіть рядок для запису:");
        String line = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME)){
            writer.write(line + "\n");
            System.out.println("Запис додано.");
        } catch (IOException e) {
            System.out.println("Помилка при записі до файлу: " + e.getMessage());
        }
        ReadTheFile();
    }

    private static void ReadTheFile() throws IOException {
        try(FileReader reader = new FileReader(FILE_NAME)) {
            int character;
            boolean isEmpty = true;

            while((character = reader.read()) != -1) {
                System.out.print((char) character);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("[Файл порожній]");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
        System.out.println("\n-------------------");
    }
}