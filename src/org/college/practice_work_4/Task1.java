package org.college.practice_work_4;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a, b, x, f = 0;

        System.out.print("Введіть a: ");
        a = sc.nextDouble();

        System.out.print("Введіть b: ");
        b = sc.nextDouble();

        System.out.print("Введіть x: ");
        x = sc.nextDouble();

        if (x >= 1 && x < 3) {
            f = 9 / (a * x);
        } else if (x == 3) {
            f = a * x * x + x + b;
        } else {
            System.out.println("x не входить до області визначення [1, 3]");
            return;
        }

        System.out.println("Значення функції f(x) = " + f);
    }
}
