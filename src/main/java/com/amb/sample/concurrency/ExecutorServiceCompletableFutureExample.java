package com.amb.sample.concurrency;

import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorServiceCompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("Thread name >>>>>>>>>>>> " + Thread.currentThread().getName() );
                return "Hello";
            }
        };


        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(supplier, executorService);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(supplier, executorService);
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(supplier, executorService);

        CompletableFuture completableFuture = CompletableFuture.allOf(task1, task2, task3);
        while (!completableFuture.isDone()) {
            System.out.println("Still processing");
        }
        System.out.println("ThreadPool Size: " + executorService.getPoolSize());
        completableFuture.whenComplete((o, o2) -> {
            System.out.println("All completed");
        });
        String combined = Stream.of(task1, task2, task3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(":"));
        System.out.println("Combined result: " +combined);
        executorService.shutdown();
    }
}
