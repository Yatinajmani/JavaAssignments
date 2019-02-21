package com.ttn.assignment.feb_19;

import java.util.Scanner;

/**
 * Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special
 * Characters In A String
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        calculateCharacters(str);
    }

    /**
     * This method takes one argument i.e the string in which we have to count occurences.This method uses String
     * class's toCharArray() method to split characters and then compares using ASCII codes.
     *
     * @param str
     */
    private static void calculateCharacters(String str) {
        float lowercaseCharacters = 0;
        float uppercaseCharacters = 0;
        float digits = 0;
        float otherCharacters = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 65 && ch <= 90)
                uppercaseCharacters++;
            else if (ch >= 97 && ch <= 122)
                lowercaseCharacters++;
            else if (ch >= 48 && ch <= 57)
                digits++;
            else
                otherCharacters++;
        }
        System.out.println("No. of lowercase characters : " + lowercaseCharacters + " And % is " +lowercaseCharacters*100/str.length());
        System.out.println("No. of uppercase characters : " + uppercaseCharacters + " And % is " +uppercaseCharacters*100/str.length());
        System.out.println("No. of digits : " + digits + " And % is " + digits*100/str.length());
        System.out.println("No. of otherCharacters : " + otherCharacters + " And % is " +otherCharacters*100/str.length());
    }
}
