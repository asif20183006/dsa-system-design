package org.example.mutithreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExtrinsicLockExample {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        Runnable thread = new Runnable() {
            @Override
            public void run() {
                bankAccount.withDrawAmount(50);
            }
        };

        Thread t1 = new Thread(thread, "T1");
        Thread t2 = new Thread(thread, "T2");

        t1.start();
        t2.start();



    }
}

class BankAccount {

    private final Lock lock = new ReentrantLock();
    private int balance = 100;

    public void withDrawAmount(int amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

              try {
                  System.out.println(Thread.currentThread().getName() + " Proceeding to withdraw amount...");
                  Thread.sleep(3000);

                  if (balance >= amount) {
                      balance -= amount;
                  }
                  System.out.println(Thread.currentThread().getName() + " Completed remaining balance: " + balance);
              } catch (Exception e) {
                  Thread.currentThread().interrupt();
              } finally {
                  lock.unlock();
              }
            } else {
                System.out.println(Thread.currentThread().getName() + " Come after some time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
