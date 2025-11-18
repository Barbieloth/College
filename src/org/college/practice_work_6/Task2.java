package org.college.practice_work_6;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість кутів: ");
        int n = sc.nextInt();

        int[] angles = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Кут " + (i + 1) + ": ");
            angles[i] = sc.nextInt();
            sum += angles[i];
        }

        int required = 180 * (n - 2);

        if (sum == required) {
            System.out.println("Такий багатокутник МОЖЕ існувати.");
        } else {
            System.out.println("Такий багатокутник НЕ може існувати.");
        }
    }
}
