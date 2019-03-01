package com.ttn.assignment.feb_28_java_8;

import java.util.Scanner;
import java.util.UUID;

/**
 * Create and access default and static method of an interface.
 */
public class Exercise6 implements CustomGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String string = scanner.nextLine();
//      Using static slugify method of CustomGenerator interface to generate a slug value from the string provided.
        System.out.println("Generated Slug using static method : " + CustomGenerator.slugify(string));
//      Using default getToken method of CustomGenerator interface without overriding it as it an default method
//      which generate a random unique hexadecimal value.
        System.out.println("Unique Token : using default method" + new Exercise6().getToken());
    }
}

interface CustomGenerator {
    //  static method for using without an instance.
    static String slugify(String string) {
        return string.replace(' ', '-');
    }

    //  default method for using without overriding to provide backward compatibility.
    default String getToken() {
        return UUID.randomUUID().toString();
    }
}
