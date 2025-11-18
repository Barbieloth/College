package org.college.practice_work_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }

        for(int x : arr){
            if(x % 2 == 0){
                // якщо число  парне(ділится без остачі на 2 ) збільшується лічильник парних чисел
                even++;
            } else {
                // в іншому випадку збільшуєтся лічильник не парних чисел
                odd++;
            }
        }

        System.out.println("Згенерований масив: " + Arrays.toString(arr));
        System.out.println("Кількість парних чисел: " + even);
        System.out.println("Кількість непарних чисел: " + odd);
    }
}
