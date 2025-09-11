package org.example.mutithreads;

public class ThreadCommunicationExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

    }
}

class SharedResource {

    boolean hasData = false;
    private int data;

    public synchronized void produceData(int data) {
        try {
            if (hasData) {
//                System.out.println(Thread.currentThread().getName()  + " is waiting for produce data " + data);
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        hasData = true;
        this.data = data;
        System.out.println(Thread.currentThread().getName()  + " is produced data " + data);
        notify();
    }

    public synchronized int consumeData() {
        try {
            if (!hasData) {
//                System.out.println(Thread.currentThread().getName()  + " is waiting for consume data");
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        hasData = false;
        System.out.println(Thread.currentThread().getName()  + " is consumed data " + data);
        notify();
        return data;
    }


}

class Producer implements Runnable{
    private SharedResource sharedResource;
    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            sharedResource.produceData(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource sharedResource;
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            sharedResource.consumeData();
        }
    }
}