package org.example.mutithreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {

    private final Lock lock = new ReentrantLock(true);


    public void executeTask() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " Started");
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + " completed");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessLockExample f = new FairnessLockExample();
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                f.executeTask();
            }
        };


        Thread t1 = new Thread(thread, "T1");
        Thread t2 = new Thread(thread, "T2");
        Thread t3 = new Thread(thread, "T3");
        t1.start();
        t2.start();
        t3.start();
    }

}
