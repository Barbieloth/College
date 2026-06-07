package org.college.practice_work_22;

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

        int[] array1= Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);
        int[] array4 = Arrays.copyOf(array, array.length);
        int[] array5 = Arrays.copyOf(array, array.length);
        int[] array6 = Arrays.copyOf(array, array.length);


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

        long startTime4 = System.nanoTime();
        countingSort(array4);
        long endTime4 = System.nanoTime();
        long nanos4 = endTime4 - startTime4;
        long millis4 = nanos4 / 1000000;

        long startTime5 = System.nanoTime();
        mergeSort(array5);
        long endTime5 = System.nanoTime();
        long nanos5 = endTime5 - startTime5;
        long millis5 = nanos5 / 1000000;

        long startTime6 = System.nanoTime();
        quickSort(array6);
        long endTime6 = System.nanoTime();
        long nanos6 = endTime6 - startTime6;
        long millis6 = nanos6 / 1000000;

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

        System.out.println("\nСортування підрахунком: ");
        System.out.println(Arrays.toString(array4));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis4, nanos4);

        System.out.println("\nСортування злиттям: ");
        System.out.println(Arrays.toString(array5));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis5, nanos5);

        System.out.println("\nШвидке сортування: ");
        System.out.println(Arrays.toString(array6));
        System.out.printf("Було відсортовано елементів за %d мс (%d нс).\n", millis6, nanos6);
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

    public static void countingSort(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        int[] count = new int[max+1];

        for(int num : arr){
            count[num]++;
        }

        int index = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }

        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortInternal(arr, 0, arr.length - 1);
    }

    private static void quickSortInternal(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSortInternal(arr, low, pivotIndex - 1);
            quickSortInternal(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}