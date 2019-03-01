package com.ttn.assignment.feb_28_java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find the first even number in the integer list which is greater than 3.
 */
public class Exercise12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        while (true) {
            System.out.println("Enter a no. (0 to exit).");
            int x = scanner.nextInt();
            if (x != 0)
                integerList.add(x);
            else {
                System.out.println("Element is : " + integerList
                        .stream()
//                      filter is a method used to get a stream of values matches a particular condition, it takes a
//                      predicate as it's argument
                        .filter(integer -> integer % 2 == 0)
                        .filter(value -> value > 3)
//                      findFirst method is used to get the first value that is coming from the stream pipeline and
//                      returns an optional object.
//                      orElse is a method of optional class that takes an argument and returns that if optional is
//                      empty
                        .findFirst().orElse(0));
                break;
            }
        }

    }
}
