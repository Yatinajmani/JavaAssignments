package com.ttn.assignment.feb_19;

/**
 * Find common elements between two arrays.
 *
 */
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

    /**
     * This method is used for sorting the array
     * @param arr1
     */
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

    /**
     * This method takes a sorted array as input and is used to remove duplicate element if exist in the array,
     * this creates a new array with checking whether the element next to it is same or not therefore we check this
     * till second last element and append array with last element.
     *
     * @param sortedArray
     * @return new length of the array having no duplicates
     */
    private static int removeDuplicates(int[] sortedArray) {
        int j = 0;
        int temp[] = new int[sortedArray.length];
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] != sortedArray[i + 1]) {
                temp[j] = sortedArray[i];
                j++;
            }
        }
        temp[j] = sortedArray[sortedArray.length - 1];
        j++;
        for (int i = 0; i < j; i++) {
            sortedArray[i] = temp[i];
        }
        return j;
    }
}