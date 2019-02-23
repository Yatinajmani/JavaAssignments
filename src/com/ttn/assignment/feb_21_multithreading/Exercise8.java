package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
 */
public class Exercise8 {
    public static void main(String[] args) {
//      ScheduledExecutorService is an ExecutorService that can schedule commands to run after a given
//      delay, or to execute periodically.To get it instance we use newSingleThreadScheduledExecutor.
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

//      schedule method of ScheduledExecutorService is used to schedule a task after a delay of particular time.
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed after 1 second");
            }
        }, 1, TimeUnit.SECONDS);

//      scheduleWithFixedDelay method of ScheduledExecutorService is used to schedule and executes a periodic action
//      after a delay of particular time.This method submits a task only after the last task is finishes.
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    System.out.println("ScheduleWithFixedDelay Scheduled Task to executed after fixed interval");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 0, 1, TimeUnit.SECONDS);

//      scheduleWithFixedRate method of ScheduledExecutorService is used to schedule and executes a periodic action
//      after a delay of particular time.This method submits a task in every period irrespective of whether the
//      earlier task finished or not.
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    System.out.println("ScheduleAtFixedRate Scheduled Task to executed after fixed interval");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
