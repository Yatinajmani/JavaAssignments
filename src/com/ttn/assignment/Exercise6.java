package com.ttn.assignment;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr1 = {11, 11, 2, 2, 3, 3, 4, 4, 55, 55, 33};
        System.out.println("Array : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        Exercise5.sort(arr1);
        System.out.println();
        System.out.println("Odd Element : " + findOddOne(arr1));
    }

    private static int findOddOne(int[] arr1) {
        int size = arr1.length;
        if (arr1[size - 1] != arr1[size - 2])
            return arr1[size - 1];
        if (arr1[0] != arr1[1])
            return arr1[0];
        for (int i = 1; i < size - 1; i++) {
            if (arr1[i] != arr1[i - 1] && arr1[i] != arr1[i + 1])
                return arr1[i];
        }
        return -1;
    }
}
