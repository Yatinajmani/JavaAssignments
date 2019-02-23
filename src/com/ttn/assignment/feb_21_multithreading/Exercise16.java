package com.ttn.assignment.feb_21_multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create a deadlock and Resolve it using tryLock().
 */
public class Exercise16 {

    private Lock lock1 = new ReentrantLock(true);

    private Lock lock2 = new ReentrantLock(true);

//  This method helps in resolving the deadlock condition as it used tryLock and if it returns true it is being
//  unlocked thereafter in this method so that the lock is acquired by the current thread as it is available.
    private boolean acquireLock(Lock lock1, Lock lock2) {

//      Acquires the lock only if it is free at the within the given waiting time and the
//      current thread has not been interrupted.
        boolean acquireLock1 = false;
        boolean acquireLock2 = false;
        try {
            acquireLock1 = lock1.tryLock(1, TimeUnit.SECONDS);
            acquireLock2 = lock2.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (acquireLock1 && acquireLock2) {
            return true;
        }

        if (acquireLock1) {
            lock1.unlock();
        }

        if (acquireLock2) {
            lock2.unlock();
        }
        return false;
    }

    public void consumer() {
/*
        Created Deadlock
        lock1.lock();
        lock2.lock();
*/

//      Resolving deadlock
        if (acquireLock(lock1, lock2)) {
            System.out.println("consumer Started");
            System.out.println("consumer Finished");
            lock2.unlock();
            lock1.unlock();
        }

    }

    public void producer() {
/*
        Created Deadlock
        lock1.lock();
        lock2.lock();
*/
        if (acquireLock(lock1, lock2)) {
            System.out.println("producer Started");
            System.out.println("producer Finished");
            lock1.unlock();
            lock2.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Exercise16 exercise16 = new Exercise16();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                exercise16.consumer();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                exercise16.consumer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                exercise16.producer();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread3.join();
        thread2.join();
    }
}
