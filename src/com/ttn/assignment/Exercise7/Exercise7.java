package com.ttn.assignment.Exercise7;

public class Exercise7 {
    public static void main(String[] args) {
        Trainee.firstName = "Yatin";
        Trainee.lastName = "Ajmani";
        Trainee.age = 24;
        System.out.println("FirstName : " + Trainee.firstName + ", LastName : " + Trainee.lastName + ", Age: " + Trainee.age);
        System.out.println("FirstName : " + Trainee.getFirstName() + ", LastName : " + Trainee.getLastName() + ", Age: " + Trainee.getAge());
    }
}
