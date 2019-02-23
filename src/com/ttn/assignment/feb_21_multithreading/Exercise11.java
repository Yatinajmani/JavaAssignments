package com.ttn.assignment.feb_21_multithreading;

/**
 * Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
 */
public class Exercise11 {
    private Integer count=0;

    public static void main(String[] args) {

//      Shared object
        Exercise11 exercise11 = new Exercise11();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise11.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise11.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise11.printThreadName();
                }
            }
        }).start();
    }

    //  synchronized block helps in making shared data more consistent by acquiring lock on it.
    void printThreadName() {
        synchronized (count) {
            count++;
            System.out.println(count);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
