package org.example.mutithreads.executorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) {


        System.out.println("main");
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            return 10;
//        }).thenAccept(System.out::println);


//        boolean complete = CompletableFuture.supplyAsync(() -> 10).complete(10);
//        System.out.println(
//                complete
//        );

//        System.out.println(CompletableFuture.supplyAsync(()-> 10).thenApply(a-> a*a).thenAccept(System.out::println));

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        try {
            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName());
                return 10;
            }, executorService);

            System.out.println(integerCompletableFuture.get());

        } catch (Exception e) {

        }




    }
}
