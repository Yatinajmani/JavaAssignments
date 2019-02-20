package com.ttn.assignment.exercise7;

/**
 * Write a program to print your Firstname,LastName & age using static block,static method & static variable
 * respectively
 */
public class Exercise7 {
    public static void main(String[] args) {

        System.out.print("FirstName : ");
        System.out.print("LastName : " + Trainee.getLastName() + ", Age: " + Trainee.age);
    }
}
