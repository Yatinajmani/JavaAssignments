package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Submit List of tasks to ExecutorService and wait for the completion of all the tasks.
 */
public class Exercise7 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() {
                try {
                    for (int i = 1; i <= 2; i++) {
                        System.out.println("Thread Waiting " + i + " seconds.");
                        Thread.sleep(1000 * i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        executorService.shutdown();

//      awaitTermination method waits for specified time for completion of all tasks,also returns sooner
//      if all tasks finishes early.
        executorService.awaitTermination(2000L, TimeUnit.MILLISECONDS);

        if (executorService.isTerminated()) {
            System.out.println("Terminated");
        } else {
            System.out.println("ExecutorService waited for Two Seconds, tasks are still remaining");
        }
    }
}
