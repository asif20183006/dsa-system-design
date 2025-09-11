package org.example.mutithreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteThreadExample {

    private int count = 0;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void getCount() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
        readLock.unlock();
    }

    public void increment() {
        writeLock.lock();
        count++;
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
        writeLock.unlock();
    }

    public static void main(String[] args) {

        ReadWriteThreadExample rw = new ReadWriteThreadExample();

        Runnable readTask = () -> {
            for (int i =0; i< 10; i++) {
                rw.getCount();
            }
        };

        Runnable writeTask = () -> {
            for (int i =0; i< 10; i++) {
                rw.increment();
            }
        };


        Thread readThreadOne = new Thread(readTask, "readThreadOne");
        Thread writeThreadOne = new Thread(writeTask, "writeThreadOne");
        Thread readThreadTwo = new Thread(readTask, "readThreadTwo");

        readThreadOne.start();
        writeThreadOne.start();
        readThreadTwo.start();
    }


}
