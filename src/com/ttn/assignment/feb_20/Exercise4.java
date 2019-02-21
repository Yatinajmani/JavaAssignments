package com.ttn.assignment.feb_20;

/**
 * WAP to create singleton class.
 */
public class Exercise4 {
    public static void main(String[] args) {
//      Getting the an instance of SingletonClass.
        SingletonClass singletonClass = SingletonClass.getInstance();
        System.out.println("SingletonClass instance Created.Having value of x : " + singletonClass.getX());
//      Setting the value of private variable of SingletonClass
        singletonClass.setX(11);
//      Getting the another instance of SingletonClass.This will return the same instance used before.
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        System.out.println("SingletonClass instance used Having value of x : " + singletonClass.getX());
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

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // private constructor restricted to this class itself
    private SingletonClass() {
        x = 10;
    }

    // static method to create instance of SingletonClass class
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
