package com.ttn.assignment.feb_20;

/**
 * Create a custom exception that do not have any stack trace.
 * We can accomplish this by overriding the printStackTrace method of Throwable class
 */
public class Exercise13 extends Exception {
    public static void main(String[] args) {
        try {
            throw new Exercise13();
        } catch (Exercise13 e) {
            e.printStackTrace();
        }
    }
    @Override
    public void printStackTrace() {

    }
}
