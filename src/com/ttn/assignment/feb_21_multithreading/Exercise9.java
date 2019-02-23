package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
 */
public class Exercise9 {
    public static void main(String[] args) {
//      newCachedThreadPool Creates a thread pool that creates new threads as needed, but will reuse previously
//      constructed threads when they are available.These pools improves the performance of programs that execute
//      many short asynchronous tasks.
        ExecutorService executorService = Executors.newCachedThreadPool();

//      newFixedThreadPool Creates a thread pool that reuses a fixed number of threads and cannot change its size.
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Executing from newCachedThreadPool");
            }
        });
        for (int i = 1; i <= 10; i++) {
            executorService.submit(new Task(i));
        }
        executorService.shutdown();
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Executing from newFixedThreadPool");
            }
        });
        for (int i = 1; i <= 9; i++) {
            executorService1.submit(new Task(i));
        }
        executorService1.shutdown();

    }

}

class Task implements Runnable {
    int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name :" + Thread.currentThread().getName() + " Started with :" + id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name :" + Thread.currentThread().getName() + " Ended with :" + id);
    }
}
