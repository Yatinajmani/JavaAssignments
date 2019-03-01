package com.ttn.assignment.feb_28_java_8;

import java.util.UUID;

/**
 * Override the default method of the interface.
 */
public class Exercise7 implements TokenGenerator {
    //  overriding default method to use as per requirements.
    @Override
    public String getToken() {
        return UUID.randomUUID().toString().replace('-', '_');
    }

    public static void main(String[] args) {
        System.out.println("Custom Unique Token using default method : " + new Exercise7().getToken());
    }
}


interface TokenGenerator {
    //  default method for using without overriding to provide backward compatibility.
    default String getToken() {
        return UUID.randomUUID().toString();
    }
}