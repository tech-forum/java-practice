package com.amb.sample.maths;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    @Test
    public void tesCentury() {
        Assert.assertEquals(18, century(1705));
        Assert.assertEquals(20, century(2000));
    }

    @Test
    public void testNextBiggerNumber() {
        //Assert.assertEquals(110, nextBiggerNumber(110));
        Assert.assertEquals(997, nextBiggerNumber(979));
        Assert.assertEquals(580, nextBiggerNumber(508));
        Assert.assertEquals(21, nextBiggerNumber(21));
        Assert.assertEquals(21, nextBiggerNumber(12));
    }
    public long nextBiggerNumber(long number) {

        long orig = number;
        if (number == -1) {
            return number;
        }
        if (number < 100) {
            long rem = number%10;
            number = rem*10 + number/10;
            return number > orig ? number : orig;
        }
        return (number/10)*10 + nextBiggerNumber(number%10);
    }

    public int century(int year) {
        int century = year%100 == 0 ? year/100 : year/100+1;
        return century;
    }
}
