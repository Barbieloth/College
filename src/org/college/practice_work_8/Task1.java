package org.college.practice_work_8;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String str = sc.nextLine();

        boolean palindrom = true;
        String str1 = str.toLowerCase().replaceAll(" ", "");

        for(int i =0; i<str1.length() / 2; i++){
            if(str1.charAt(i) != str1.charAt(str1.length() - 1 - i)){
                palindrom = false;
                break;
            }
        }

        if(palindrom){
            System.out.println("Строка є паліндромом");
        } else{
            System.out.println("Строка не є паліндромом");
        }
    }
}
