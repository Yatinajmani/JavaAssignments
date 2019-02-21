package com.ttn.assignment.feb_20;

import java.util.Scanner;

/**
 * WAP to read words from the keyboard until the word done is entered. For each word except done,
 * report whether its first character is equal to its last character. For the required loop, use a
 * a)while statement
 * b)do-while statement
 */
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Using While : ");
        usingWhile();
        System.out.println("Using Do While : ");
        usingDoWhile();
    }

    /**
     * This method is used to compare last and first character of the strings entered at the starting and before
     * entering "done" using while loop.
     */
    private static void usingWhile() {
        Scanner scanner = new Scanner(System.in);
//      Getting first character from the string entered.
        String string1 = String.valueOf(scanner.next().charAt(0));
        String string2 = null;
        String string3 = null;
//      Avoiding NullPointerException using equals on string literal.
        while (!"done".equals(string2)) {
            if (string2 != null)
                string3 = String.valueOf(string2.charAt(0));
            string2 = scanner.next();
        }
        if (string3.equals(string1)) {
            System.out.println("First character is equal to its last character");
        } else
            System.out.println("First character is not equal to its last character");
    }

    /**
     * This method is used to compare last and first character of the strings entered at the starting and before
     * entering "done" using do-while loop.
     */
    private static void usingDoWhile() {
        Scanner scanner = new Scanner(System.in);
        String string1 = String.valueOf(scanner.next().charAt(0));
        String string2 = null;
        String string3 = null;
        do {
            if (string2 != null)
                string3 = String.valueOf(string2.charAt(0));
            string2 = scanner.next();
        } while (!"done".equals(string2));
        if (string1.equals(string3)) {
            System.out.println("First character is equal to its last character");
        } else
            System.out.println("First character is not equal to its last character");
    }
}
