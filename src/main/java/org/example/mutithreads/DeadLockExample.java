package org.example.mutithreads;

public class DeadLockExample {
    public static void main(String[] args) {

        Paper paper = new Paper();
        Pen pen = new Pen();

        Task1 task1 = new Task1(pen, paper);

        Task2 task2 = new Task2(pen, paper);

        task2.start();
        task1.start();

    }
}
class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " has Pen trying to use Paper");
        paper.finishWritting();

    }
    public synchronized void finishWritting() {
        System.out.println(Thread.currentThread().getName() + " Pen task completed");
    }
}

class Paper {
    public synchronized void writeWithPenAndPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " has paper trying to use pen");
        pen.finishWritting();

    }
    public synchronized void finishWritting() {
        System.out.println(Thread.currentThread().getName() + " Paper task completed");
    }
}

class Task1 extends Thread {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (paper) {
            pen.writeWithPenAndPaper(paper);
        }
    }
}

class Task2 extends Thread {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.writeWithPenAndPaper(pen);
    }
}