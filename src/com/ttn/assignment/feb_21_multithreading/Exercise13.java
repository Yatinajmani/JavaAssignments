package com.ttn.assignment.feb_21_multithreading;

/**
 * Coordinate 2 threads using wait() and notify().
 *
 * While using wait and notify use of synchronized methods/blocks is done as both the object's definition requires
 * calling thread to hold a monitor otherwise they me run into an IllegalMonitorStateException.
 */
public class Exercise13 {
    public static void main(String[] args) {
        Exercise13 exercise13 = new Exercise13();
        new Thread(new Runnable() {
            @Override
            public void run() {
                exercise13.printThreadName();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                exercise13.printThreadName2();
            }
        }).start();

    }

    private void printThreadName2() {
        synchronized (this) {
            System.out.println("Printing from 2 ");
            System.out.println("Printing from 2 Completed.");
//          Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this
//          object, one of them is chosen to be awakened on random basis.
            notify();
        }
    }

    private void printThreadName() {
        synchronized (this) {
            System.out.println("Printing from 1 ");
            try {
//              Causes the current thread to wait until another thread invokes the notify method or the notifyAll()
//              method for this object.
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing from 1 Completed.");
        }
    }
}
