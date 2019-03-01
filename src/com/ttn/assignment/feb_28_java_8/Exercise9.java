package com.ttn.assignment.feb_28_java_8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Collect all the even numbers from an integer list.
 */
public class Exercise9 {
    public static void main(String[] args) {
//      IntStream is used to create a stream of primitive int values that can be used to perform aggregate methods
        System.out.println("Even Numbers between 1-10 : " + IntStream
//      rangeClosed is a static method used to get a stream of int values of the specified range
                        .rangeClosed(1, 10)
//      filter is a method used to get a intStream of int values that matches a particular condition, it takes a
//      predicate as it's argument
                        .filter(value -> value % 2 == 0)
//      boxed is a method used to get a intStream of type Integers from the
                        .boxed()
//      collect method is used to collect the stream output in a particular collection type
                        .collect(Collectors.toList())
        );
    }
}
