package org.college.practice_work_7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int rows = 5;
        int cols = 6;
        double[][] arr = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = rand.nextDouble() * 100.0f;
            }
        }

        System.out.println("Оригінальний масив");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.4f", arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nМасив після sqrt");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if((i % 2 == 1) && (j % 2 == 1)) {
                    arr[i][j] = Math.sqrt(arr[i][j]);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%8.4f", arr[i][j]);
            }
            System.out.println();
        }
    }
}
