package org.example.mutithreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();


    public void outer() {
        lock.lock();
        try {
            System.out.println("OuterLock...........");
            inner();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("InnerLock...........");
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        Runnable thread = reentrantLockExample::outer;

        thread.run();


    }
}
