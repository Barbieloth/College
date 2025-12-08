package org.college.practice_work_8;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String str = sc.nextLine();
        String Camel = "";

        String[] parts = str.split("[\\-_]+");

        Camel += parts[0].toLowerCase();

        for(int i = 1; i < parts.length; i++){
            if(parts[i].length() > 0){
                String word = parts[i].toLowerCase();
                Camel += Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }
        }

        System.out.println("Camel: " + Camel);


    }
}
