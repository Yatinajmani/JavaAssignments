package com.ttn.assignment.feb_22_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a method that takes a string and print the number of occurrence of each character characters in the string.
 */
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String string = scanner.nextLine();
        countOccurrences(string);
    }

    /**
     * countOccurrences method takes an string argument and uses a Map which is part of java collection framework
     * and stores key value pair, a HashMap is the implementation of a map using a hash table for managing keys.
     * Internally map used to use array of linked list but after JDK 1.8.
     *
     * @param string Random string
     */
    private static void countOccurrences(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch :
                string.toCharArray()) {
//          put method is used to add key value pair in the map.
//          getOrDefault method is added in JDK 1.8 and is used to get value to which the specified key is mapped, or
//          returns defaultValue if the map contains no mapping for the key.
            Integer put = map.getOrDefault(ch, 0);
            map.put(ch, ++put);
        }
//      keySet method is used to get all keys from the map.
        for (char ch :
                map.keySet()) {
            System.out.println("No. of " + ch + " : " + map.get(ch));
        }
    }
}
