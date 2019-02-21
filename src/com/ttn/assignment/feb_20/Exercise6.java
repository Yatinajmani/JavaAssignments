package com.ttn.assignment.feb_20;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * WAP showing try, multi-catch and finally blocks.
 */
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println(exceptionMethod()==-1?"Exceptions Occurred":"No Exceptions Occurred");
    }

    private static int exceptionMethod() {
        try {
//          Here there will be an ExceptionInInitializerError as the class has an runtime ArithmeticException
//          So the class will not be created successfully
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Two Numbers : ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int variable = a / b;
            System.out.println("Division : " + variable);
            new ErrorClass();
        } catch (ArithmeticException | ExceptionInInitializerError| InputMismatchException e) {
            e.printStackTrace();
//          This will be returned after the finally block.
            return -1;
        } finally {
//          This will be executed every time.
            System.out.println("Finally Block. Always Printed");
        }
        return 0;
    }

    static class ErrorClass {
        static int variable = 1 / 0;
    }
}
