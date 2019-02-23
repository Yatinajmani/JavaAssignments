package com.ttn.assignment.feb_21_multithreading;

/**
 * Create and Run a Thread using Runnable Interface and Thread class.
 *
 * Implementing Runnable is preferred as it provides scope for class to extend any other parent class and do not
 * restrict the class to extend any other class as in Thread extension it will violate java's multiple inheritance.
 */
public class Exercise1 {
    public static void main(String[] args) {

        ThreadExtension threadExtension = new ThreadExtension(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread in Execution using Thread Class");
            }
        });

        Thread runnableThread = new Thread(new RunnableThread());

        runnableThread.start();
        threadExtension.start();
    }
}

/**
 * This class extends Thread class and can be used as a thread and will work as per the run method provided by the
 * constructor of the ThreadExtension class.
 */
class ThreadExtension extends Thread {
    ThreadExtension(Runnable target) {
        super(target);
    }
}

/**
 * This class implements Runnable Interface and can be used in a thread and will work as per the run method provided
 * by the overridden method run in this class.
 */
class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread in Execution " +
                "using Runnable Interface.");
    }
}
