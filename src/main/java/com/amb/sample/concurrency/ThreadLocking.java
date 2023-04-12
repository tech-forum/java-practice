package com.amb.sample.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadLocking {
    public static void main(String[] args) {
        ThreadLocking threadLocking = new ThreadLocking();
        System.out.println("============No Lock Example==============================");
        //threadLocking.noLockExample();
        System.out.println("============Class Lock Example==============================");
        //threadLocking.classLockExample();
        System.out.println("============Object Lock Example==============================");
        //threadLocking.objectLockExample();
        System.out.println("============Object Lock Example - New instance per thread==============================");
        //threadLocking.objectLockNewInstancesExample();
        System.out.println("============Static method - Class level lock Example==============================");
        //threadLocking.staticMethodClassLevelLockExample();
        System.out.println("============Non Static method - object level lock Example==============================");
        threadLocking.nonStaticMethodClassLevelLockExample();

        System.out.println("==========================================");

    }

    public void classLockExample() {
        ClassLockThread lockThread = new ClassLockThread();
        AtomicInteger range = new AtomicInteger(0);
        IntStream.range(0, 5).forEach(value -> {
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    class ClassLockThread implements Runnable {
        int count = 1;
        @Override
        public void run() {

            synchronized (ClassLockThread.class)
            {
                System.out.println( "in block " + Thread.currentThread().getName() + " Ends. Final count is " + count++);
            }
        }
    }

    /**
     * Output - Since only one stance is used by all threads, lock in effect - see the count
     * in block T1 Ends. Final count is 1
     * in block T2 Ends. Final count is 2
     * in block T4 Ends. Final count is 3
     * in block T3 Ends. Final count is 4
     * in block T5 Ends. Final count is 5
     */
    public void objectLockExample() {
        ObjectLockThread lockThread = new ObjectLockThread();
        AtomicInteger range = new AtomicInteger(0);
        IntStream.range(0, 5).forEach(value -> {
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    /**
     * Output - Since all objects are new, no lock in effect
     * in block T3 Ends. Final count is 1
     * in block T4 Ends. Final count is 1
     * in block T1 Ends. Final count is 1
     * in block T2 Ends. Final count is 1
     * in block T5 Ends. Final count is 1
     */
    public void objectLockNewInstancesExample() {
        AtomicInteger range = new AtomicInteger(0);
        IntStream.range(0, 5).forEach(value -> {
            ObjectLockThread lockThread = new ObjectLockThread();
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    /**
     * Output - static method is synchronized, applied class level lock
     * in block T1 Ends. Final count is 1
     * in block T2 Ends. Final count is 2
     * in block T4 Ends. Final count is 3
     * in block T3 Ends. Final count is 4
     * in block T5 Ends. Final count is 5
     */
    public void staticMethodClassLevelLockExample() {
        AtomicInteger range = new AtomicInteger(0);
        StaticObjectLockThread lockThread = new StaticObjectLockThread();
        IntStream.range(0, 5).forEach(value -> {
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    /**
     * Output - static method is synchronized, applied class level lock
     * in block T1 Ends. Final count is 1
     * in block T2 Ends. Final count is 2
     * in block T4 Ends. Final count is 3
     * in block T3 Ends. Final count is 4
     * in block T5 Ends. Final count is 5
     */
    public void nonStaticMethodClassLevelLockExample() {
        AtomicInteger range = new AtomicInteger(0);
        NonStaticObjectLockThread lockThread = new NonStaticObjectLockThread();
        IntStream.range(0, 5).forEach(value -> {
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    class ObjectLockThread implements Runnable {
        int count = 1;
        @Override
        public void run() {

            synchronized (this)
            {
                System.out.println( "in block " + Thread.currentThread().getName() + " Ends. Final count is " + count++);
            }
        }
    }

    class StaticObjectLockThread implements Runnable {
        AtomicInteger count = new AtomicInteger(1);
        @Override
        public void run() {
            printStaticSync(count);
        }
    }

    class NonStaticObjectLockThread implements Runnable {
        AtomicInteger count = new AtomicInteger(1);
        @Override
        public void run() {
            printNonStaticSync(count);
        }
    }

    private static synchronized void printStaticSync(AtomicInteger count) {
        System.out.println( "in block " + Thread.currentThread().getName() + " Ends. Final count is " + count.getAndIncrement());
    }

    private synchronized void printNonStaticSync(AtomicInteger count) {
        System.out.println( "in block " + Thread.currentThread().getName() + " Ends. Final count is " + count.getAndIncrement());
    }

    public void noLockExample() {
        NoLockThread lockThread = new NoLockThread();
        AtomicInteger range = new AtomicInteger(0);
        IntStream.range(0, 5).forEach(value -> {
            Thread t = new Thread(lockThread);
            t.setName("T"+ range.incrementAndGet());
            t.start();
        });
    }

    class NoLockThread implements Runnable {

        int count = 1;

        @Override
        public void run() {
            System.out.println( "in block " + Thread.currentThread().getName() + " Ends. Final count is " + count++);
        }
    }
}
