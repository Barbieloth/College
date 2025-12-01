package org.college.practice_work_7;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір матриці n (наприклад 3, 4, 5...): ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rand.nextInt(19) - 9;
            }
        }

        System.out.println("\nМатриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }

        // Введення елементу, мінор якого треба знайти
        System.out.print("\nВведіть номер рядка елемента (від 1 до " + n + "): ");
        int r = sc.nextInt() - 1;   // -1 бо користувач вводить 1..n, а індекси 0..n-1

        System.out.print("Введіть номер стовпця елемента (від 1 до " + n + "): ");
        int c = sc.nextInt() - 1;

        // Створюємо матрицю (n-1) × (n-1) — це мінор
        int[][] minor = new int[n - 1][n - 1];

        int mi = 0; // індекс рядка в мінорі
        for (int i = 0; i < n; i++) {

            if (i == r) continue; // пропускаємо вибраний рядок

            int mj = 0; // індекс стовпця в мінорі
            for (int j = 0; j < n; j++) {

                if (j == c) continue; // пропускаємо вибраний стовпець

                minor[mi][mj] = arr[i][j];
                mj++;
            }
            mi++;
        }

        // Виводимо мінор
        System.out.println("\nМінор (" + (r+1) + ", " + (c+1) + "):");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.printf("%5d", minor[i][j]);
            }
            System.out.println();
        }
    }
}

