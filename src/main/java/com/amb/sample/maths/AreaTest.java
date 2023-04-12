package com.amb.sample.maths;

import org.junit.Assert;
import org.junit.Test;

public class AreaTest {
    @Test
    public void testAreaOrPerimeter() {
        Assert.assertEquals(32, areaOrPerimeter(6, 10));
        Assert.assertEquals(9, areaOrPerimeter(3, 3));
    }

    public int areaOrPerimeter(int l, int w) {
        int result = 0;
        if (l == w) {
            result = l * w;
        } else {
            result = (2 * l) + (2 * w);
        }
        return result;
    }
}
