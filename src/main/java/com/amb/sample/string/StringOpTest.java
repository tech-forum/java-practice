package com.amb.sample.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class StringOpTest {

    @Test
    public void testFeast() {
        Assert.assertTrue(feast("great blue heron", "garlic nann"));
        assertFalse(feast("brown bear","bear claw"));
    }

    public boolean feast(String beast, String dish) {
        if (beast.charAt(0) == dish.charAt(0)
                && beast.charAt(beast.length()-1) == dish.charAt(dish.length()-1)) {
            return true;
        }
        return false;
    }
}
