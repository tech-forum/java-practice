package com.amb.sample.functional;

@FunctionalInterface
public interface FunctionalInt<T, U, V> {

    V testFunctional(T t, U u);

    default void defaultBehavior() {
        System.out.println("Printing default behavior");
    }
}
