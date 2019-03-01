package com.ttn.assignment.feb_28_java_8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write the following a functional interface and implement it using lambda:
 * (1) First number is greater than second number or not Parameter (int ,int ) Return boolean
 * (2) Increment the number by 1 and return incremented value Parameter (int) Return int
 * (3) Concatination of 2 string Parameter (String , String ) Return (String)
 * (4) Convert a string to uppercase and return Parameter (String) Return (String)
 */
public class Exercise1 {
    public static void main(String[] args) {
//      Using lambda to provide the implementation of the functional interface.
        Scanner scanner = new Scanner(System.in);
        CheckGreater checkGreater = (a, b) -> a > b;
        System.out.println("Enter Two numbers to compare : ");
        try {
            System.out.println("First is greater : " + checkGreater.compare(scanner.nextInt(), scanner.nextInt()));

            Increment increment = a -> a + 1;
            System.out.println("Enter a number to increment : ");
            System.out.println(increment.inc(scanner.nextInt()));
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer " + e);
        }

        Concatenation concatenation = (a, b) -> a + b;
        System.out.println("Enter Two strings to concatenate : ");
        scanner.nextLine();
        System.out.println(concatenation.concate(scanner.nextLine(), scanner.nextLine()));

        ConvertCase convertCase = a -> a.toUpperCase();
        System.out.println("Enter a string to convert to uppercase : ");
        System.out.println(convertCase.toUpper(scanner.nextLine()));
    }
}

@FunctionalInterface
interface CheckGreater {
    boolean compare(int a, int b);
}

@FunctionalInterface
interface Increment {
    int inc(int a);
}

@FunctionalInterface
interface Concatenation {
    String concate(String string, String string1);
}

@FunctionalInterface
interface ConvertCase {
    String toUpper(String string);
}
