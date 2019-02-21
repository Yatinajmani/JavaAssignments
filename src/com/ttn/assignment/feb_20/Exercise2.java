package com.ttn.assignment.feb_20;

import java.util.Scanner;

/**
 * WAP to sorting string without using string Methods?
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char ch[] = str.toCharArray();  // to break string into char Arrays.
        sort(ch); // sorting array.
        System.out.print("Sorted string : ");
        System.out.print(ch); // overriden method returns array of character represented as string;
    }

    /**
     * This method is using insertion sort to sort character array
     *
     * @param chars Array of characters to be sorted
     */
    private static void sort(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (chars[j] < chars[j - 1]) {
                    char temp = chars[j - 1];
                    chars[j - 1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
    }

}
