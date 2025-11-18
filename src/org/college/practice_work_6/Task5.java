package org.college.practice_work_6;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Генерація випадкових значень (від 0 до 99)
        for(int i = 0; i < n; i++){
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Згенерований масив: " + Arrays.toString(arr));

        System.out.println("Оберіть режим перевірки:");
        System.out.println("1 — перевірити на зростання");
        System.out.println("2 — перевірити на спадання");
        int choice = sc.nextInt();

        boolean ok = true;

        if (choice == 1) { // зростання
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i-1]) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "Масив зростає." : "Масив НЕ зростає.");
        }
        else if (choice == 2) { // спадання
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i-1]) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "Масив спадає." : "Масив НЕ спадає.");
        }
        else {
            System.out.println("Невірний вибір.");
        }
    }
}
