package org.college.practice_work_7;

public class Task1 {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new int[n][];
        int value = 1;

        for(int i = 0; i < n; i++){
            arr[i]= new int[i + 1];
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j]=value++;
            }
        }

        System.out.println("Звичайний порядок:");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\nЗворотній порядок:");
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
