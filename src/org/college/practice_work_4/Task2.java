package org.college.practice_work_4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ціле число: ");
        int number = sc.nextInt();

        int reversed = 0;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.printf("Реверс (while): %010d\n", reversed);

        temp = number;
        reversed = 0;

        do {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        } while (temp != 0);

        System.out.printf("Реверс (do-while): %010d\n", reversed);
    }
}
