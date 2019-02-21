package com.ttn.assignment.feb_20.exercise5;

public class Application {
    public static void main(String[] args) {

        Exercise5 exercise5 = new Exercise5("A String");
        Exercise5 exercise51 = null;
        try {
//          Using cloneable method
            exercise51 = exercise5.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("From Cloneable : " + exercise51.getName());

//      Using CopyConstructor
        Exercise5 exercise52 = new Exercise5(exercise5);
        System.out.println("From Copy Constructor : " + exercise52.getName());
    }
}
