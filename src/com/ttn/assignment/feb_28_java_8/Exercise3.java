package com.ttn.assignment.feb_28_java_8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference
 * create and apply multiplication method for the functional interface created.
 */
public class Exercise3 {
    private static int multiply(int a, int b) {
        return a * b;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
//      Using (instance) Method reference to provide the implementation of the functional interface.
//      As the add method is non-static of Exercise3 class and matches the signature of operate hence using instance
//      method Reference.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Two numbers : ");
        int j = 0;
        int i = 0;
        try {
            i = scanner.nextInt();
            j = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer " + e);
        }
        Operation add = new Exercise3()::add;
        System.out.println("Addition " + add.operate(i, j));

        Operation sub = new Exercise3()::subtract;
        System.out.println("Difference " + sub.operate(i, j));

//      Using (static) Method reference to provide the implementation of the functional interface.
//      As the add method is static of Exercise3 class and matches the signature of operate hence using static
//      method Reference.
        Operation mul = Exercise3::multiply;
        System.out.println("Product " + mul.operate(i, j));
    }
}

@FunctionalInterface
interface Operation {
    int operate(int a, int b);
}