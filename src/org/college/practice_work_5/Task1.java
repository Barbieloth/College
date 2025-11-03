package org.college.practice_work_5;
import java.lang.Math;
public class Task1 {
    public static void main(String[] args) {
        final double a = 4.5 * Math.pow(10, 4);
        final double b = -2 * Math.pow(10, 5);
        final double c = 25;

        double x = Math.pow(1 + Math.pow(Math.tan(a / 2), 2), Math.sqrt(Math.abs(b)+c ));

        double y = 2 * (1/ Math.tan(a / Math.abs(b))); // ctg(x) = 1 / tan(x)

        System.out.println("x = " + x);
        System.out.println("y = " + y);

    }
}
