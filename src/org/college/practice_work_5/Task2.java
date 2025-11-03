package org.college.practice_work_5;
import java.lang.Math;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Бажаєте ввести данні вручнну? (y/n)");
        char ch = sc.next().charAt(0);

        double a, b, x;

        if (ch == 'y') {
            // Ручне введення
            System.out.print("Введіть значення a: ");
            a = sc.nextDouble();
            System.out.print("Введіть значення b: ");
            b = sc.nextDouble();
            System.out.print("Введіть значення x: ");
            x = sc.nextDouble();
        } else {
            // Випадкове генерування
            a = (Math.random() * ((5 - (-5)) + 1 )) + (-5) ;
            b = (Math.random() * ((5 - (-5)) + 1 )) + (-5) ;
            x = (Math.random() * ((13 - (-2)) + 1 )) + (-2) ;

            System.out.printf("Згенеровані значення:%n a = %.2f, b = %.2f, x = %.2f%n", a, b, x);

        }

        double f;

        // Обчислення f(x)
        if (x> -2 && x <5) {
            if (a * x + 3 <= 0) {
                System.out.println("Помилка: аргумент логарифма має бути > 0.");
                return;
            }
            f = Math.log(a * x + 3);
        } else if (x == 5) {
            f = Math.pow(x ,2) - b * x +7;
        } else if (x > 5) {
            f = Math.cos(x + 1);
        } else {
            System.out.println("x не належить області визначення функції (-2, +∞).");
            return;
        }
        System.out.printf("f(%.2f) = %.4f%n", x, f);
    }
}
