package org.college.practice_work_8;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String str = sc.nextLine();

        String[] words = str.split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for(int i = 1; i < words.length; i++){
            if(words[i].length() < shortest.length()){
                shortest = words[i];
            }
            if(words[i].length() > longest.length()){
                longest = words[i];
            }

        }
        System.out.println("Найкоротше слово: " + shortest + " (" + shortest.length() + " символів)");
        System.out.println("Найдовше слово: " + longest + " (" + longest.length() + " символів)");

    }
}
