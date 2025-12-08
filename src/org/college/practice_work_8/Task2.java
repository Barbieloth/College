package org.college.practice_work_8;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String str = sc.nextLine();
        String strRev = "";

        // Цикл проходить по рядку з кінця до початку і додає кожен символ у зворотному порядку
        for(int i = str.length() - 1; i >= 0; i--){
            strRev += str.charAt(i);
        }

        System.out.println("Оригінальна строка: " + str);
        System.out.println("Інвертована строка: " + strRev);

    }
}
