package com.ttn.assignment.feb_21_multithreading;

/**
 * Coordinate mulitple threads using wait() and notifyAll()
 */
public class Exercise14 {
    public static void main(String[] args) {
        Exercise14 exercise14 = new Exercise14();
        new Thread(new Runnable() {
            @Override
            public void run() {
                exercise14.printThreadName();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                exercise14.printThreadName3();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                exercise14.printThreadName2();
            }
        }).start();
    }

    private void printThreadName3() {
        synchronized (this) {
            System.out.println("3 On waiting.");
            try {
//              Causes the current thread to wait until another thread invokes the notify method or the notifyAll()
//              method for this object.
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting over for 3.");
        }
    }

    private void printThreadName2() {
        synchronized (this) {
            System.out.println("Printing from 2.");
            System.out.println("Printing from 2 Completed.");
//          Wakes up all threads that are waiting on this object's monitor.
            notifyAll();
        }
    }

    private void printThreadName() {
        synchronized (this) {
            System.out.println("1 On waiting.");
            try {
//              Causes the current thread to wait until another thread invokes the notify method or the notifyAll()
//              method for this object.
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting over for 1.");
        }
    }
}
