package com.ttn.assignment.mar_1_design_patterns;

/**
 * Implement Singleton Design Pattern on a dummy class.
 */
public class Exercise1 {
    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();
        System.out.println("SingletonClass instance Created.Having value of variable : " + singletonClass
                .getVariable());
//      Setting the value of private variable of SingletonClass
        singletonClass.setVariable(11);
//      Getting the another instance of SingletonClass.This will return the same instance used before.
        System.out.println("SingletonClass instance used Having value of variable : " + SingletonClass.getInstance()
                .getVariable());
    }
}

/**
 * This is a singleton class using Lazy initialization method that creates the instance in the global access method
 * when required.
 * Also it is using thread safe instance creation if it is not created before.
 */
class SingletonClass {
    // static variable instance of type SingletonClass
    private static SingletonClass instance = null;

    private int variable;

    int getVariable() {
        return variable;
    }

    void setVariable(int variable) {
        this.variable = variable;
    }

    // private constructor restricted to this class itself
    private SingletonClass() {
        variable = 10;
    }

    // static method to info instance of SingletonClass class
    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
