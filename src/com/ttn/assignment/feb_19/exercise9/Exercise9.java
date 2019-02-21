package com.ttn.assignment.feb_19.exercise9;

/**
 * Write a program to display values of enums using a constructor & getPrice() method
 * (Example display house & their prices)
 */
public class Exercise9 {
    public static void main(String[] args) {
        House house = House.VILLA;
        System.out.println("Cost of : " + house + " is Rs." + house.getPrice());
    }
}