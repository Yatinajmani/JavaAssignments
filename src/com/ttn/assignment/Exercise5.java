package com.ttn.assignment;

public class Exercise5 {
    public static void main(String[] args) {
        int[] arr1 = {11, 2, 3, 4, 55, 1, 2, 1, 5};
        int[] arr2 = {1, 22, 3, 54, 5, 11};
        sort(arr1);
        sort(arr2);
        int newSize = removeDuplicates(arr1);
        int newSize2 = removeDuplicates(arr2);

        System.out.println("Common Elements : ");
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize2; j++) {
                if (arr1[i] == arr2[j])
                    System.out.println(arr1[i]);
            }
        }
    }

    private static int removeDuplicates(int[] arr1) {
        int j = 0;
        int temp[] = new int[arr1.length];
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] != arr1[i + 1]) {
                temp[j] = arr1[i];
                j++;
            }
        }
        temp[j] = arr1[arr1.length - 1];
        j++;
        for (int i = 0; i < j; i++) {
            arr1[i] = temp[i];
        }
        return j;
    }

    public static void sort(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            int temp;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] > arr1[j]) {
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
    }
}