package com.ttn.assignment.feb_28_java_8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Create a functional interface whose method takes 2 integers and return one integer.
 */
public class Exercise2 {
    public static void main(String[] args) {
//      Using lambda to provide the implementation of the functional interface.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Two numbers to add : ");
        try {
            Addition addition = (a, b) -> a + b;
            System.out.println(addition.add(scanner.nextInt(), scanner.nextInt()));
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer " + e);
        }
    }
}

@FunctionalInterface
interface Addition {
    int add(int a, int b);
}