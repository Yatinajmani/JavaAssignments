package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().
 *
 */
public class Exercise15 {
//  ReentrantLock is by the thread last thread successfully locking, but not yet unlocking it.
//  When true is set under contention, locks favor granting access to the longest-waiting thread.
//  Otherwise this lock does not guarantee any particular access order. Programs using fair locks accessed
//  by many threads may display lower overall throughput (i.e., are slower; often much slower) than those using
//  the default setting, but guarantee lack of starvation.
    Lock lock = new ReentrantLock(true);

//  Conditions are used in order for a thread to be notified, when a condition is true.
    Condition condition = lock.newCondition();

    public void consumer() {
        try {
//          acquiring a lock on current thread
            lock.lock();
            System.out.println("consumer Started");
//          await method Causes the current thread to wait until it is signalled or interrupted. The lock associated
//          with this condition is atomically released and the current thread becomes disabled for thread scheduling
//          purposes and lies waiting state until some other thread signals it.
            condition.await();
            System.out.println("consumer Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//          releasing the lock.
            lock.unlock();
        }

    }

    public void producer() {
        try {
            lock.lock();
            System.out.println("producer Started");
            System.out.println("producer Finished");
//          Wakes up one waiting thread.If any threads are waiting on this condition then one is selected for waking
//          up. That thread must then re-acquire the lock before returning from await.
            condition.signal();

//          Wakes up all waiting threads.If any threads are waiting on this condition then they are all woken up.
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Exercise15 exercise15 = new Exercise15();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                exercise15.consumer();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                exercise15.producer();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
