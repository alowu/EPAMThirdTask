package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class SphereLogicTest {

    private final double RADIUS = 2.8217;
    private final double EXPECTED_SQUARE = 100;
    private final double EXPECTED_VALUE = 94;
    private final double DELTA = 1e3;

    private final Dot CENTER = new Dot(1, 1, 1);

    private final Sphere SPHERE = new Sphere(CENTER, RADIUS, 0);

    @Test
    public void testCalculateSquareShouldCalculateSquareOfOrb() {
        SphereLogic logic = new SphereLogic();

        double result = logic.calculateSquare(SPHERE);

        Assert.assertEquals(EXPECTED_SQUARE, result, DELTA);
    }

    @Test
    public void testCalculateValueShouldCalculateValueOfOrb() {
        SphereLogic logic = new SphereLogic();

        double result = logic.calculateVolume(SPHERE);

        Assert.assertEquals(EXPECTED_VALUE, result, DELTA);
    }

    @Test
    public void testCalculateRatioShouldCalculateRatioOfVolumes() {
        SphereLogic logic = new SphereLogic();

        double result = logic.volumeRatio(SPHERE,'y');

        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void testCalculateRatioShouldCalculateRatioOfVolumesWithDefaultParameter() {
        SphereLogic logic = new SphereLogic();

        double result = logic.volumeRatio(SPHERE);

        Assert.assertEquals(3.07, result, DELTA);
    }
}
