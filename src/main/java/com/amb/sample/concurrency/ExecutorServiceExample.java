package com.amb.sample.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executor executor = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        Future<String> output = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread Name >>>>>:" + Thread.currentThread().getName());
                return "Hello";
            }
        });
        while(!output.isDone()) {
            System.out.println("Still processing");
        }
        System.out.println("ThreadPool Size: " + executorService.getPoolSize());
        System.out.println("Processing completed: " + output.get());
        System.out.println("ThreadPool Size: " + executorService.getPoolSize());
        executorService.shutdown();

    }
}
