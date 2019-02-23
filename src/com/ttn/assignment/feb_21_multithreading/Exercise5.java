package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Use isShutDown() and isTerminate() with ExecutorService.
 */
public class Exercise5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Empty Thread");
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
//          isShutdown method Returns true when ExecutorService is shutdown, irrespective whether the task have been
//          completed or not.
                if (executorService.isShutdown()) {
                    System.out.println("ExecutorService Shutdown Successfully.");
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread With Sleep.");
//                  This will make current thread sleep for 2 seconds.
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
        while (true) {
//          isTerminated method Returns true only iff all tasks have completed following shut down. This method
//          is never true unless either shutdown() or shutdownNow() was executed first.
            if (executorService.isTerminated()) {
                System.out.println("ExecutorService Terminated Successfully.");
                break;
            }
        }

        System.out.println("Main Thread Executed Successfully.");
    }
}
