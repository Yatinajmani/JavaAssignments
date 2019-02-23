package com.ttn.assignment.feb_22_collection;

import java.util.*;

/**
 * Write a method that takes a string and returns the number of unique characters in the string.
 */
public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String string = scanner.nextLine();
        System.out.println("No. of unique characters in " + string + " : " + uniqueChar(string));
    }

    /**
     * uniqueChar methods takes an string argument and returns the number of unique characters using a set instance.
     * Set is an interface from java collection framework that stores only unique values using a Map internally.
     * HashSet is class that implements set and can perform operations on set instance.
     * @param string Random String
     * @return Count of unique characters
     */
    private static int uniqueChar(String string) {
        Set<Character> characters=new HashSet<>();
        for (char ch:string.toCharArray()) {
//          Used to add an objects in set only if it is not already there.
            characters.add(ch);
        }
//      Returns no. of elements present in the Set.
        return characters.size();
    }
}
