package com.ttn.assignment.exercise7;

class Trainee {
    static String firstName = "y";
    static String lastName = "a";
    static Integer age = 0;

    static {
        System.out.println("FirstName : " + firstName + ", LastName : " + lastName + ", Age: " + age);
    }

    static String getFirstName() {
        return firstName;
    }

    static String getLastName() {
        return lastName;
    }

    static Integer getAge() {
        return age;
    }
}
