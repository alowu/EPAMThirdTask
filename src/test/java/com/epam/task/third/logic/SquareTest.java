package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

    private final static double RADIUS = 2.8217;
    private final static double EXPECTED = 100;
    private final static double DELTA = 1e3;

    private final static Sphere sphere = new Sphere(new Dot(), RADIUS);

    @Test
    public void testCalculateSquareShouldCalculateSquareOfOrb() {
        Square square = new Square();

        double result = square.calculate(sphere);

        Assert.assertEquals(EXPECTED, result, DELTA);
    }
}
