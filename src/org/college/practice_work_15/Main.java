package org.college.practice_work_15;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class Main {
    private static String[] dates = new String[10];
    private static String[] records = new String[10];
    private static String[] times = new String[10];
    private static int currentCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Мій щоденник ---");
        System.out.println("1. Відновити щоденник\n2. Створити новий\nВибір: ");
        String StartChoise = sc.nextLine();

        if (StartChoise.equals("1")) {
            System.out.println("Введіть шлях до файлу: ");
            loadFromFile(sc.nextLine());
        }

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
                    exitWithSave(sc);
                    running = false;
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
        String dateInput = sc.nextLine();

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalDate date = LocalDate.parse(dateInput, pattern);
            dateInput = date.format(pattern);
        } catch (DateTimeParseException e) {
            System.out.println("Помилка: некоректний формат дати.");
            return;
        }

        String currentTime = LocalTime.now().format(timePattern);


        System.out.println("Введіть текст (порожній рядок для завершення):");
        String content = "";
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            content += line + "\n";
        }

        dates[currentCount] = dateInput;
        times[currentCount] = currentTime;
        records[currentCount] = content;
        currentCount++;
        System.out.println("Збережено.");
    }

    public static void viewAllRecord() {
        if (currentCount == 0) {
            System.out.println("Щоденник порожній.");
            return;
        }

        for (int i = 0; i < currentCount; i++) {
            System.out.println("\n[" + dates[i] + " " + times[i] + "]");
            System.out.println(records[i].replace("\\n", "\n"));
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
                times[i] = times[i + 1];
                records[i] = records[i + 1];
            }
            currentCount--;
            System.out.println("Запис за " + dateToDelete + " видалено.");
        } else {
            System.out.println("Запис не знайдено.");
        }
    }
    public static void exitWithSave(Scanner sc){
        System.out.print("Зберегти зміни? (так/ні): ");
        if (sc.nextLine().equalsIgnoreCase("так")) {
            System.out.print("Введіть шлях до файлу: ");
            saveToFile(sc.nextLine());
        }
    }
    private static void saveToFile(String path){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for(int i = 0; i < currentCount; i++){
                bw.write(dates[i] + "|" + times[i]);
                bw.newLine();
                bw.write(records[i]);
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            System.out.println("Дані збережено успішно.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні: " + e.getMessage());
        }
    }
    private static void loadFromFile(String path){
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Файл за вказаним шляхом не знайдено.");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            currentCount = 0;
            String line;
            while((line = br.readLine()) != null && currentCount < dates.length){
                if (line.trim().isEmpty()) continue;

                String[] dateTime = line.split("\\|");
                if (dateTime.length == 2) {
                    dates[currentCount] = dateTime[0];
                    times[currentCount] = dateTime[1];
                }

                String content = br.readLine();
                if (content != null) {
                    records[currentCount] = content;
                    currentCount++;
                }
                br.readLine();
            }
            System.out.println("Відновлено записів: " + currentCount);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}
