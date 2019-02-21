package com.ttn.assignment.feb_20;

/**
 * WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
 */
public class Exercise3 {
    public static void main(String[] args) {
        try {
//          There is no class with name NotDefinedClass hence this will give a ClassNotFoundException
            Class.forName("NotDefinedClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
//          Here there will be an ExceptionInInitializerError as the class has an runtime ArithmeticException
//          So the class will not be created successfully
            new ErrorClass();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//          As the class is not created it will give NoClassDefFoundError
            new ErrorClass();
        }
    }

    static class ErrorClass {
        static int arr = 1 / 0;
    }
}