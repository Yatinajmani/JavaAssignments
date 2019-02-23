package com.ttn.assignment.feb_21_multithreading;

/**
 * Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.
 */
public class Exercise10 {

    public static void main(String[] args) {

//      Shared object
        Exercise10 exercise10 = new Exercise10();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise10.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise10.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise10.printThreadName();
                }
            }
        }).start();
    }

//  Once a thread is executing it's printThreadName method no other thread can preempt the same from it.
//  synchronized helps in making shared data and methods more reliable and consistent.
    synchronized void printThreadName() {
        System.out.println("From Synchronized method : " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}