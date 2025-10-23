package org.college.practice_work_4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть число N: ");
        int N = sc.nextInt();

        System.out.println("Прості числа від 1 до " + N + ":");

        for (int i = 1; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}
