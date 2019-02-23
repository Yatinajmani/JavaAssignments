package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.*;

/**
 * Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled() with the Future
 * object to know the status of task submitted.
 */
public class Exercise6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//      Future is used to determine the result of an asynchronous task thread.
//      Future Object having generic type Integer
        Future<Integer> integerFuture = null;
        try {
//          Overridden submit method is used which takes an reference to an Callable Interface which submits a
//          task for execution and returns a Future representing the pending results of the task.

//          Callable Interface has a functional interface that has a method call which returns the Generic type
//          value as a result to the task submited.
            integerFuture = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    return 0;
                }
            });

//          Cancel method is used to interrupt a task if in execution
            integerFuture.cancel(true);

            executorService.shutdown();

//          isDone method checks whether the task has been completed successfully or not
            if (integerFuture.isDone()) {
//          get method is used to fetch the resulting value from the given future object if task has been completed.
                System.out.println(integerFuture.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
//          isCancelled method checks whether the task was cancelled or not.
            if (integerFuture.isCancelled()) {
                System.out.println("Your task has been cancelled");
            }
        }
    }
}
