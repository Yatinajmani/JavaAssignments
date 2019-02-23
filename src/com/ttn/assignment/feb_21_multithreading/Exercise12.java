package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Use Atomic Classes instead of Synchronize method and blocks.
 *
 * AtomicClasses are used in applications such as atomically incremented counters, as they are using synchronized
 * methods/block internally and can provide the same functionality of consistency easily.
 */
public class Exercise12 {
    private AtomicInteger count;
    {
        count=new AtomicInteger(0);
    }
    public static void main(String[] args) {

//      Shared object
        Exercise12 exercise12 = new Exercise12();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise12.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise12.printThreadName();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    exercise12.printThreadName();
                }
            }
        }).start();
    }

    void printThreadName() {
//      Incrementing and getting the Value of AtomicInteger
        System.out.println(count.incrementAndGet());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

