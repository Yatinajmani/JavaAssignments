package com.ttn.assignment.feb_19;

/**
 * There is an array with every element repeated twice except one. Find that element
 * This could have also be done using xor of every element and returning the value will be the element
 */
public class Exercise6 {
    public static void main(String[] args) {
        int[] arr1 = {11, 11, 2, 2, 3, 3, 4, 4, 55, 55, 33};
        System.out.println("Array : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        Exercise5.sort(arr1);   //To sort the array.
        System.out.println();
        System.out.println("Odd Element : " + findOddOne(arr1));
    }

    /**
     * This method is checking from second element to second last element whether element before and after is not
     * equal then this return the value if this is the case.
     * For checking first and last element this simply compare next and second last elements respectively and return
     * if they are not equal.
     *
     * @param sortedArray
     * @return Odd element
     */
    private static int findOddOne(int[] sortedArray) {
        int size = sortedArray.length;
        if (sortedArray[0] != sortedArray[1]) {
            return sortedArray[0];
        }
        for (int i = 1; i < size - 1; i++) {
            if (sortedArray[i] != sortedArray[i - 1] && sortedArray[i] != sortedArray[i + 1]) {
                return sortedArray[i];
            }
        }
        if (sortedArray[size - 1] != sortedArray[size - 2])
            return sortedArray[size - 1];
        return -1;
    }
}
