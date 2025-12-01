package org.college.practice_work_7;

import java.util.Random;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір квадратної матриці: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int[][] tran = new int[n][n];

        System.out.println("\nПочаткова матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rand.nextInt(10 - (-10)) + (-10);
            }
        }

        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tran[j][i] = arr[i][j];
            }
        }
        System.out.println("\nТранспонована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tran[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
