package org.college.practice_work_19;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.print("Введіть мінімальне значення діапазону: ");
        int min = scanner.nextInt();

        System.out.print("Введіть максимальне значення діапазону: ");
        int max = scanner.nextInt();

        if (min > max) {
            System.out.println("Помилка: мінімальне значення не може бути більшим за максимальне.");
            return;
        }

        System.out.print("Виберіть спосіб сортування (1 - за зростанням, 2 - за спаданням): ");
        int choice = scanner.nextInt();
        boolean ascending;
        if (choice == 1) {ascending = true; }  else {ascending = false;}

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }

        System.out.println("\nМасив до сортування:");
        System.out.println(Arrays.toString(array));

        long startTime = System.nanoTime();

        sort(array, ascending);

        long endTime = System.nanoTime();
        long nanos = endTime - startTime;
        long millis = nanos / 1000000;

        System.out.println("\nМасив після сортування:");
        System.out.println(Arrays.toString(array));
        System.out.printf("\nБуло відсортовано елементів за %d мс (%d нс).\n", millis, nanos);
    }
    public static void sort(int[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1; j++) {
                boolean shouldSwap = false;

                if(ascending) { if (arr[j] > arr[j + 1]) {shouldSwap = true; }
                } else { if (arr[j] < arr[j + 1]) {shouldSwap = true;} }

                if (shouldSwap) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

            }
            if(!swapped) {break;}
        }
    }
}
