package org.example.mutithreads.executorService;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future1 = executorService.submit(new MyTask(countDownLatch));
        Future<String> future2 = executorService.submit(new MyTask(countDownLatch));
        Future<String> future3 = executorService.submit(new MyTask(countDownLatch));

        boolean await = countDownLatch.await(1, TimeUnit.SECONDS);

        System.out.println("Main: " + await);

        executorService.shutdown();

    }
}

class MyTask implements Callable<String> {

    private CountDownLatch countDownLatch;
    public MyTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public String call() throws Exception {
       try {
           Thread.sleep(2000);
           System.out.println(Thread.currentThread().getName() + " Task completed");
       } finally {
           countDownLatch.countDown();
       }
        return "ok";
    }
}
