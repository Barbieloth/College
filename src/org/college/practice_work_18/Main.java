package org.college.practice_work_18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        Scanner sc = new Scanner(System.in);
        boolean running= true;

        while (running) {

            System.out.println("\n--- ГОЛОВНЕ МЕНЮ ---");
            System.out.println("1. Додати елемент в кінець");
            System.out.println("2. Додати елемент за індексом");
            System.out.println("3. Видалити елемент за індексом");
            System.out.println("4. Отримати елемент за індексом");
            System.out.println("5. Показати кількість елементів (size)");
            System.out.println("6. Показати місткість буфера (capacity)");
            System.out.println("7. Вивести всі елементи (getAllElements)");
            System.out.println("0. Вихід");
            System.out.print("Оберіть дію: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1": {
                        System.out.print("Введіть рядок для додавання: ");
                        list.add(sc.nextLine());
                        System.out.println("Успішно додано.");
                    } break;
                    case "2": {
                        System.out.print("Введіть індекс: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.print("Введіть рядок: ");
                        list.add(idx, sc.nextLine());
                        System.out.println("Елемент вставлено.");
                    } break;
                    case "3": {
                        System.out.print("Введіть індекс для видалення: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        String removed = list.remove(idx);
                        System.out.println("Видалено елемент: " + removed);
                    } break;
                    case "4": {
                        System.out.print("Введіть індекс: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.println("Результат: " + list.get(idx));
                    } break;
                    case "5": {
                        System.out.println("Кількість елементів: " + list.size());
                    } break;
                    case "6": {
                        System.out.println("Загальна місткість буфера: " + list.capacity());
                        System.out.println("(Це сума всіх комірок у створених блоках)");
                    } break;
                    case "7": {
                        String[] all = list.getAllElements();
                        if (all.length == 0) {
                            System.out.println("Список порожній.");
                        } else {
                            System.out.println("Весь список:");
                            for (int i = 0; i < all.length; i++) {
                                System.out.println("[" + i + "] " + all[i]);
                            }
                        }
                    } break;
                    case "0": {
                        running = false;
                        System.out.println("Завершення роботи...");
                    } break;
                    default: {System.out.println("Невірний ввід, спробуйте ще раз.");}
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка індексу: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число для індексу.");
            } catch (Exception e) {
                System.out.println("Виникла помилка: " + e.getMessage());
            }
        }
    }
}
