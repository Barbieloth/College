package org.college.practice_work_8;

import java.util.Scanner;
// Мама сказала що дасть мені мандарини якщо я закрию сесію та отримаю стипендію
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("text");
        String str = sc.nextLine();

        String[] verybadwords = {
                "мандарини",
                "стипендію",
                "сесію",
        };

        String rep = "[Цензура]";
        String result = str;

        for(int i = 0; i < verybadwords.length; i++){
            result = result.replaceAll("(?i)" + verybadwords[i], rep);
        }

        System.out.println(result);
    }
}
