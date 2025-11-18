package org.college.practice_work_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Генерація випадкових значень (від 0 до 99)
        for(int i = 0; i < n; i++){
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Згенерований масив: " + Arrays.toString(arr));

        // Значення для пошуку
        System.out.print("Введіть значення, яке потрібно знайти: ");
        int valueToFind = sc.nextInt();

        // Значення на заміну
        System.out.print("Введіть значення для заміни: ");
        int valueToReplace = sc.nextInt();


        boolean found = false;
        // Перевірка усіх елементів масиву
        for(int i = 0; i < arr.length; i++){
            // Перевірка чи збігаєтся число в масиві з числом яке треба знайти
            if(arr[i] == valueToFind){
                // Заміна елементу якщо він був знайдений
                arr[i] = valueToReplace;
                // Позначення що хоч одна заміна була виконана
                found = true;
            }
        }

        // Результат
        if(found){
            System.out.println("Масив після заміни: " + Arrays.toString(arr));
        } else {
            System.out.println("Значення " + valueToFind + " не знайдено у масиві.");
        }
    }
}
