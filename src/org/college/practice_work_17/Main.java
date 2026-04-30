package org.college.practice_work_17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList goodList = new MyList();
        Scanner sc = new Scanner(System.in);
        boolean running= true;

        while (running) {

            System.out.println("\n--- ГОЛОВНЕ МЕНЮ ---");
            System.out.println("1. Додати елемент в кінець");
            System.out.println("2. Додати елемент за індексом");
            System.out.println("3. Видалити елемент за індексом");
            System.out.println("4. Отримати елемент за індексом");
            System.out.println("5. Кількість присутніх елементів");
            System.out.println("6. Кількість елементів у буфері");
            System.out.println("7. Тест");
            System.out.println("0. Вихід");
            System.out.print("Оберіть дію: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1": {
                        System.out.print("Введіть рядок для додавання: ");
                        goodList.add(sc.nextLine());
                        System.out.println("Успішно додано.");
                    } break;
                    case "2": {
                        System.out.print("Введіть індекс: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.print("Введіть рядок: ");
                        goodList.add(idx, sc.nextLine());
                        System.out.println("Елемент вставлено.");
                    } break;
                    case "3": {
                        System.out.print("Введіть індекс для видалення: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        String removed = goodList.remove(idx);
                        System.out.println("Видалено елемент: " + removed);
                    } break;
                    case "4": {
                        System.out.print("Введіть індекс: ");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.println("Результат: " + goodList.get(idx));
                    } break;
                    case  "5": {
                        System.out.println("Поточний розмір: " + goodList.size());
                    } break;
                    case "6": {
                        System.out.println("Поточна ємність буфера: " + goodList.capacity());
                    } break;
                    case "7": {
                        for (int i = 0; i < 10; i++) {
                            goodList.add("яблучкі" + (i + 1));
                        }
                        System.out.println("Новий розмір: " + goodList.size());
                        System.out.println("Нова ємність: " + goodList.capacity());
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
