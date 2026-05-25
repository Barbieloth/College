package org.college.practice_work_20;

import java.util.*;

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

        int[] array1 = Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);

        System.out.println("\nМасив до сортування:");
        System.out.println(Arrays.toString(array));

        long startTime1 = System.nanoTime();
        BubbleSort(array1, ascending);
        long endTime1 = System.nanoTime();
        long nanos1 = endTime1 - startTime1;
        long millis1 = nanos1 / 1000000;

        long startTime2 = System.nanoTime();
        SelectionSort(array2);
        long endTime2 = System.nanoTime();
        long nanos2 = endTime2 - startTime2;
        long millis2 = nanos2 / 1000000;

        long startTime3 = System.nanoTime();
        InsertionSort(array3);
        long endTime3 = System.nanoTime();
        long nanos3 = endTime3 - startTime3;
        long millis3 = nanos3 / 1000000;

        System.out.println("\nМасив після сортування:\n");

        System.out.println("Бульбашкове сортування: ");
        System.out.println(Arrays.toString(array1));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis1, nanos1);

        System.out.println("\nВибіркове сортування: ");
        System.out.println(Arrays.toString(array2));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis2, nanos2);

        System.out.println("\nСортування вставкою: ");
        System.out.println(Arrays.toString(array3));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis3, nanos3);
    }
    public static void BubbleSort(int[] arr, boolean ascending) {
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
    public static void SelectionSort(int[] arr){
        for (int i = 0; i<arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int[] arr) {
        for(int i = 1; i<arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j]> key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;

        }
    }
}