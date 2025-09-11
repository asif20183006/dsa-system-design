package org.example.mutithreads;

public class MyThread extends Thread {
    @Override
    public void run() {

        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//
//        System.out.println(myThread.getState());
//        myThread.start();
//        System.out.println(myThread.getState());
//        System.out.println(Thread.currentThread().getState());
//        Thread.sleep(1000);
//        System.out.println(myThread.getState());
//        myThread.join();
//        System.out.println(myThread.getState());


        PriorityThread low = new PriorityThread("low");
//        low.setPriority(1);
        PriorityThread mid = new PriorityThread("mid");
//        low.setPriority(5);
        PriorityThread high = new PriorityThread("high");
//        low.setPriority(10);

        low.start();
        mid.start();
        high.start();




    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {

       for (int i =1 ;i<=5; i++) {
           String s="";
           for (int j = 1;j<=100000000; j++) {
               s+=s;
           }
           Thread.yield();

           System.out.println("Current Thread name: " + Thread.currentThread().getName() +
                   ", Priority: " + Thread.currentThread().getPriority() + " c: " + i);
       }

    }
}
