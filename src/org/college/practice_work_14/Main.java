package org.college.practice_work_14;

import java.util.Scanner;

public class Main {
    private static String[] dates = new String[10];
    private static String[] records = new String[10];
    private static int currentCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addRecord(sc);
                    break;
                case "2":
                    deleteRecord(sc);
                    break;
                case "3":
                    viewAllRecord();
                    break;
                case "4":
                    running = false;
                    System.out.println("Вихід...");
                    break;
                default:
                    System.out.println("Помилка: оберіть пункт 1-4.");
            }
        }
    }
    private static void printMenu() {
        System.out.println("\n--- МЕНЮ ЩОДЕННИКА ---");
        System.out.println("1. Додати запис");
        System.out.println("2. Видалити за датою");
        System.out.println("3. Показати всі");
        System.out.println("4. Вийти");
        System.out.print("Ваш вибір: ");
    }

    private static void addRecord(Scanner sc) {
        if (currentCount >= 10) {
            System.out.println("Місце закінчилося!");
            return;
        }

        System.out.print("Введіть дату (ДД.ММ.РРРР): ");
        String date = sc.nextLine();

        System.out.println("Введіть текст (порожній рядок для завершення):");
        String content = "";
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            content += line + "\n";
        }

        dates[currentCount] = date;
        records[currentCount] = content;
        currentCount++;
        System.out.println("Збережено.");
    }

    public static void viewAllRecord() {
        if (currentCount == 0) {
            System.out.println("Щоденник порожній.");
            return;
        }

        System.out.println("\n--- Всі записи ---");
        for (int i = 0; i < currentCount; i++) {
            System.out.println("Дата: " + dates[i] + " 00:00");
            System.out.println("Текст:\n" + records[i]);
            System.out.println("-----------------");
        }
    }

    public static void deleteRecord(Scanner sc) {
        System.out.print("Введіть дату для видалення: ");
        String dateToDelete = sc.nextLine();
        int index = -1;

        for (int i = 0; i < currentCount; i++) {
            if (dates[i].equals(dateToDelete)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < currentCount - 1; i++) {
                dates[i] = dates[i + 1];
                records[i] = records[i + 1];
            }
            currentCount--;
            System.out.println("Запис за " + dateToDelete + " видалено.");
        } else {
            System.out.println("Запис не знайдено.");
        }
    }
}
