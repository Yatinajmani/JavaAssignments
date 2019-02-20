package com.ttn.assignment;

import java.util.Scanner;

/**
 * Write a program to find the number of occurrences of a character in a string without using loop?
 * This could have also be done using Length of array and replacing character with empty string and taking
 * difference of new length and older length.
 *
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("String is : " + str);
        System.out.print("Enter character to Search : ");
        String string = scanner.next();
        System.out.println("No. of Occurences : " + findOccurences(str, string.charAt(0)));
    }

    /**
     * This method is a recursive method that takes two arguments, a string(To find occurences from) and
     * a character(To match) and returns the count.
     * This checks whether the character is in the string and if it's there this replace it with empty string
     * and recall the method and assign the value to count variable after that at the time of backing-out phase
     * this increment the count variable. If the character is not there it finally returns count value.
     *
     * @param str
     * @param ch
     * @return count of the argument ch
     */
    public static int findOccurences(String str, char ch) {
        int count = 0;
        if (str.indexOf(ch) != -1) {
            str = str.replaceFirst(ch + "", "");
            count = findOccurences(str, ch);
            count++;
        }
        return count;
    }
}
