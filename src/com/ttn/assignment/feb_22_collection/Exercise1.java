package com.ttn.assignment.feb_22_collection;

import java.util.*;

/**
 * Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator,
 * find the sum of the numbers in List.
 */
public class Exercise1 {
    public static void main(String[] args) {
//      List is an interface that extends the Collections interface that is used for storing an ordered collection.
//      List can access elements by their integer index.
//      ArrayList is a class that implements List interface so that's why we can assign it to an List instance.
        List<Float> floats = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Float sum = 0f;
        System.out.println("Enter 5 numbers.");
        int i = 0;
        try {
            for (; i < 5; i++) {
//              Adding 5 element to the float list using user input.
                floats.add(scanner.nextFloat());
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers are allowed." + e);
        }
//      Iterator is an interface that helps in iterating over a collection
//      iterator method returns an iterator on an iterable object.
        Iterator iterator = floats.iterator();
//      hasNext method returns true if the iteration has more elements.
        while (iterator.hasNext()) {
//          next method returns next element in the iterator instance.
            sum += (Float) iterator.next();
        }
        System.out.println("Sum of the no.s is : " + sum);
    }
}
