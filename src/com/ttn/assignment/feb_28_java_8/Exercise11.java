package com.ttn.assignment.feb_28_java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find average of the number inside integer list after doubling it.
 */
public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        while (true) {
            System.out.println("Enter a no. (0 to exit).");
            int x = scanner.nextInt();
            if (x != 0)
                integerList.add(x);
            else {
                System.out.println("Average : " + integerList
                        .stream()
//                      mapToInt returns an IntStream and takes a Function as an argument.
                        .mapToInt(value -> value * 2)
//                      average method is used to get the average of all the values that are coming from the
//                      stream pipeline and returns an object of OptionalDouble.
//                      orElse is used to return the value if present else returns the value in argument
                        .average().orElse(0));
                break;
            }
        }

    }
}
