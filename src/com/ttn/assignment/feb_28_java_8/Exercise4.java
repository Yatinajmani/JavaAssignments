package com.ttn.assignment.feb_28_java_8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Create an Employee Class with instance variables (String) name, (Integer)age, (String)city
 * and get the instance of the Class using constructor reference
 */
public class Exercise4 {
    public static void main(String[] args) {
//      Using constructor reference to provide the implementation of the functional interface.
//      As the Employee class constructor matches the signature of createEmployee of Instantiation interface
//      hence using constructor Reference.
        Scanner scanner = new Scanner(System.in);
        CheckGreater checkGreater = (a, b) -> a > b;
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        int age = 0;
        try {

            System.out.println("Enter age : ");
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer " + e);
        }

        System.out.println("Enter city : ");
        scanner.nextLine();
        String city = scanner.nextLine();

        Instantiation instantiation = Employee::new;
        Employee employee = instantiation.createEmployee(name, age, city);
        System.out.println(employee);
    }
}

class Employee {
    String name;
    Integer age;
    String city;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    Employee(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

@FunctionalInterface
interface Instantiation {
    //  A function having same signature as the Employee Constructor.
    Employee createEmployee(String name, Integer age, String city);
}