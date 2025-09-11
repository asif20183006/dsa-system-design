package org.example.mutithreads;

public class TestThreads {
    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.start();

        Thread thread = new Thread(new World());
        thread.start();

    }
}

class Hello extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Hello");
        }
    }
}

class World implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("World");
        }
    }
}
