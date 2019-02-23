package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Try shutdown() and shutdownNow() and observe the difference.
 */
public class Exercise4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
                try {
                    System.out.println("Thread With 3 second Sleep.");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
//      An unused ExecutorService should be shut down to allow reclamation of its resources.

//      shutdownNow method in ExecutorService Attempts to stop all actively executing tasks, stops the processing of
//      waiting tasks, and returns a list of the tasks that were awaiting execution.
        System.out.println(executorService.shutdownNow());

        System.out.println("Main Thread Executed Successfully.");
//      Shutdown method in ExecutorService is used to intimate that no new tasks will be accepted,but tasks which
//      were previously submitted tasks are executed.
        executorService.shutdown();
    }
}
