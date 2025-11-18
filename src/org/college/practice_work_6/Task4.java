package org.college.practice_work_6;

public class Task4 {
    public static void main(String[] args) {

        int count = 0;

        for(int angle = 0; angle <= 90; angle++) {

            double sin = Math.sin(angle);

            System.out.printf("%3d° = %.4f   ", angle, sin);

            count++;
            if(count == 10) {
                System.out.println();
                count = 0;
            }
        }

    }
}
