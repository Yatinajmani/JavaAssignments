package com.ttn.assignment.feb_28_java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sum all the numbers greater than 5 in the integer list.
 */
public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        while (true) {
            System.out.println("Enter a no. (0 to exit).");
            int x = scanner.nextInt();
            if (x != 0)
                integerList.add(x);
            else {
                System.out.println("Sum : " + integerList
                        .stream()
//                      mapToInt returns an IntStream and takes a Function as an argument.
                        .mapToInt(value -> value > 5 ? value : 0)
//                      sum method is used to get the sum of all the values that are coming from the stream pipeline.
                        .sum());
                break;
            }
        }
    }
}
