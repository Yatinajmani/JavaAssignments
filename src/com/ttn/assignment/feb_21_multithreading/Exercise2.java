package com.ttn.assignment.feb_21_multithreading;

/**
 * Use sleep and join methods with thread.
 *
 * Sleep is used to make the thread wait for particular time.
 * Join is used where we want the current thread to be executed ahead only after some other threads.
 * Mainly join is used to maintain dependency between threads.
 */
public class Exercise2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread With Sleep.");
//                  This will make current thread sleep for 3 seconds.
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with loop.");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });

//      These thread will be added to runnable pool.
        thread1.start();
        thread2.start();

//      These thread must finish before the execution of main thread but they are not dependent on each other.
        thread1.join();
        thread2.join();

        System.out.println("Main Thread Executed Successfully.");
    }
}
