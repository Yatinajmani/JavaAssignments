package com.ttn.assignment;

import java.util.Scanner;

/**
 * Write a program to find the number of occurrences of the duplicate words in a string and print them ?
 * This question could have been solved using Java Collection Framework.
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Original String = " + str);
        findOccurences(str);
    }

    /**
     * This method takes a string argument and splits the string around " " and iterate over each element and check
     * whether it is repeated by comparing the element with each word in provided string. Then it replace every
     * repeated element from the string with empty string and If the occurences of element is greater than 0 it print
     * that element with it's occurences.
     *
     * @param str
     */
    public static void findOccurences(String str) {
        for (String str1 : str.split(" ")) {
            int count = 0;
            for (String str2 : str.split(" ")) {
                if (str1.equals(str2))
                    count++;
            }
            str = str.replace(str1, "");
            if (count > 0)
                System.out.println("String : \"" + str1 + "\" has " + count + " Occurences");
        }
    }
}
