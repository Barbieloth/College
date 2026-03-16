package org.college.practice_work_13;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "src/org/college/practice_work_13/text.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean isRun = true;

        while(isRun){
            printMenu();
            String choise = sc.nextLine();
            switch(choise){
                case "1": writeMultipleLines(); break;
                case "2": ReadTheFile(); break;
                case "3": ReadRange(); break;
                case "4": insertAtLine(); break;
                case "5": System.out.println("Вихід з програми..."); return;
                default: System.out.println("Помилка: Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printMenu(){
        System.out.println("\n--- МЕНЮ РЕДАКТОРА ---");
        System.out.println("1. Записати декілька рядків");
        System.out.println("2. Прочитати увесь вміст");
        System.out.println("3. Вивести діапазон рядків");
        System.out.println("4. Записати в обраний рядок");
        System.out.println("5. Вихід");
        System.out.print("Оберіть дію: ");
    }

    private static void writeMultipleLines() {
        System.out.println("Скільки рядків ви хочете ввести?");
        try {
            int count = Integer.parseInt(sc.nextLine());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                for (int i = 0; i < count; i++) {
                    System.out.print((i + 1) + " | ");
                    writer.write(sc.nextLine());
                    writer.newLine();
                }
                System.out.println("Записано.");
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void ReadTheFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isEmpty = true;
            int lineNum = 1;
            System.out.println("\n--- ВМІСТ ФАЙЛУ ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNum + " | " + line);
                isEmpty = false;
                lineNum++;
            }
            if (isEmpty) {
                System.out.println("[Файл порожній]");
            }
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }

    private static void ReadRange() {
        try {
            System.out.print("Початок (номер): ");
            int start = Integer.parseInt(sc.nextLine());
            System.out.print("Кінець (номер): ");
            int end = Integer.parseInt(sc.nextLine());
            boolean isEmpty = true;

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                int current = 1;
                while ((line = reader.readLine()) != null) {

                    if (current >= start && current <= end) {
                        System.out.println(current + " | " + line);
                        isEmpty = false;
                    }
                    current++;
                }
                if (isEmpty) {
                    System.out.println("[Файл порожній]");
                }
            }
        } catch (Exception e) {
            System.out.println("Помилка діапазону: " + e.getMessage());
        }
    }
    private static void insertAtLine() {
        try {
            int totalLines = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                while (reader.readLine() != null) totalLines++;
            }

            System.out.print("В який номер рядка вставити? (1-" + (totalLines + 1) + "): ");
            int target = Integer.parseInt(sc.nextLine());
            System.out.print("Введіть текст: ");
            String newContent = sc.nextLine();

            String[] content = new String[totalLines];
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                for (int i = 0; i < totalLines; i++) {
                    content[i] = reader.readLine();
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                boolean inserted = false;
                for (int i = 0; i < totalLines; i++) {
                    if (i + 1 == target) {
                        writer.write(newContent);
                        writer.newLine();
                        inserted = true;
                    }
                    writer.write(content[i]);
                    writer.newLine();
                }

                if (!inserted) {
                    writer.write(newContent);
                    writer.newLine();
                }
            }
            System.out.println("Вставка виконана.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}