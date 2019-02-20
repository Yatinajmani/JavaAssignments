package com.ttn.assignment;

import java.util.Scanner;

/**
 * Write a program to replace a substring inside a string with other string?
 */
public class Exercise1 {

    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Original String = " + str);
        System.out.print("Enter String to replace = ");
        String stringToReplace = scanner.nextLine();
        System.out.print("Enter String to replace with = ");
        String stringToReplaceWith = scanner.nextLine();
        str = str.replace(stringToReplace,stringToReplaceWith);
        System.out.println("Modified String = " + str);
    }
}
