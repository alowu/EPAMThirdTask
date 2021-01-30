package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class ValueTest {
    private final static double RADIUS = 2.8217;
    private final static double EXPECTED = 94;
    private final static double DELTA = 1e3;

    private final static Sphere sphere = new Sphere(new Dot(), RADIUS);

    @Test
    public void testCalculateValueShouldCalculateValueOfOrb() {
        Value value = new Value();

        double result = value.calculate(sphere);

        Assert.assertEquals(EXPECTED, result, DELTA);
    }
}
