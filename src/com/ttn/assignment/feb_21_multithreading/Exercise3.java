package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Use a singleThreadExecutor to submit multiple threads.
 */
public class Exercise3 {

    public static void main(String[] args) {
/*
        ExecutorService is an interface added in JDK 1.5 that helps in managing Thread by its own.
        Executors is a Factory class that returns and instance of configured ExecutorService using different methods
        newSingleThreadExecutor method of class Executors provides single thread to work on and at a particular time
        it can execute only single task, although if this current thread failed due to some reason having pending
        tasks a new thread will take its place to execute those tasks.
*/
        ExecutorService executorService = Executors.newSingleThreadExecutor();
/*
        ExecutorService has a submit method that submits a task for execution and returns a Future class object
        representing the pending results of the task.
*/
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Empty Thread");
            }
        });

        executorService.submit(new Runnable() {
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

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with loop.");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                if (executorService.isShutdown()) {
                    System.out.println("ExecutorService Shutdown Successfully.");
                }
            }
        });

        System.out.println("Main Thread Executed Successfully.");
//      An unused ExecutorService should be shut down to allow reclamation of its resources.
//      Shutdown method in ExecutorService is used to intimate that no new tasks will be accepted,but tasks which
//      were previously submitted tasks are executed.
        executorService.shutdown();
    }
}
