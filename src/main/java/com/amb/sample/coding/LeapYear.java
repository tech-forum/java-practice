package com.amb.sample.coding;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalField;

public class LeapYear {
    public static void main(String[] args) {
        isLeapYear("2000-01-04");
        isLeapYear("2012-01-04");
        isLeapYear("2023-01-04");
    }

    private static boolean isLeapYear(String date) {
        Instant instant = Instant.now();
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("is leap year? " + localDate.isLeapYear());
        return localDate.isLeapYear();
    }
}
