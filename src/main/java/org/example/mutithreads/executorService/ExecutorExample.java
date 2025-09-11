package org.example.mutithreads.executorService;

import java.util.concurrent.*;

public class ExecutorExample {

    public static int factorial(int n){

        int ans = 1;
        for (int i =2;i<=n;i++){
            ans*=i;
        }
        return ans;
    }

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // runnable example
//        executorService.submit(() -> {
//            for (int i = 1; i<= 10; i++) {
//                System.out.println(factorial(i));
//            }
//        });
//
//        executorService.shutdown();
//

        // callable example

//        Future<Integer> submit = executorService.submit(() -> factorial(1));
//
//        try {
//            submit.cancel(true);
//            System.out.println(submit.get());
//        } catch (InterruptedException | ExecutionException | CancellationException e) {
//        }
//
//
//        System.out.println(submit.isCancelled());
//
//        executorService.shutdown();

        // executor service with only one thread

//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        // ScheduledExecutorService

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // scheduler with delay and time
//        scheduledExecutorService.schedule(()-> System.out.println("This will run after 5 sec"), 5, TimeUnit.SECONDS);

//        scheduledExecutorService.shutdown();

        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("This will run after 5 sec"), 5, 5, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(scheduledExecutorService::shutdown, 20, TimeUnit.SECONDS);

    }

}
