package org.example.mutithreads;

public class SyncronyzedDemo extends Thread {

    Counter counter;

    public SyncronyzedDemo(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i=0; i<2000;i++){
            this.counter.increment();
        }
    }

    public static void main(String[] args) {

        Counter counter1 = new Counter();
        SyncronyzedDemo t1 = new SyncronyzedDemo(counter1);
        SyncronyzedDemo t2 = new SyncronyzedDemo(counter1);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter1.getCount());

    }
}
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;

//        synchronized (this) {
//            count++;
//        }
    }

    public int getCount() {
        return count;
    }
}