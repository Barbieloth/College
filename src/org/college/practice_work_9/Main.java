package org.college.practice_work_9;

import java.util.Scanner;

public class Main {
    public static String input() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Введіть строку (мінімум 2 слова, кожне від 3 символів): ");
            input = sc.nextLine().trim();

            String[] words = input.split("\\s+");

            if (words.length < 2) {
                System.out.println("Помилка: потрібно ввести мінімум 2 слова.");
                continue;
            }

            boolean valid = true;
            for (String word : words) {
                if(word.length() < 3) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Помилка: кожне слово повинно містити мінімум 3 символи.");
            } else {
                return input;
            }


        }

    }

    public static String RevStr(String str) {
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }

    public static String RevWords(String str) {
        String[] words = str.split("\\s+");
        String result = "";

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            String reversedWord = "";

            for(int j = word.length() - 1; j >= 0; j--){
                reversedWord += word.charAt(j);
            }

            result += reversedWord;

            if(i < words.length - 1){
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String UserString = input();

        System.out.println("Оберіть дію: ");
        System.out.println("1 - Перевернути всю строку");
        System.out.println("2 - Перевернути кожне слово окремо");
        System.out.print("Ваш вибір: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println(RevStr(UserString));
                break;
            case 2:
                System.out.println(RevWords(UserString));
                break;
            default:
                System.out.println("Невірний вибір.");
        }

    }
}
