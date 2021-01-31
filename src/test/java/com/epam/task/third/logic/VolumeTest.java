package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class VolumeTest {
    private final static double RADIUS = 2.8217;
    private final static double EXPECTED_VALUE = 94;
    private final static double DELTA = 1e3;

    private final static Dot CENTER = new Dot(1, 1, 1);

    private final static Sphere SPHERE = new Sphere(CENTER, RADIUS);

    @Test
    public void testCalculateValueShouldCalculateValueOfOrb() {
        Volume volume = new Volume();

        double result = volume.calculate(SPHERE);

        Assert.assertEquals(EXPECTED_VALUE, result, DELTA);
    }

    @Test
    public void testCalculateRatioShouldCalculateRatioOfVolumes() {
        Volume volume = new Volume();

        double result = volume.volumeRatio(SPHERE,'y');

        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void testCalculateRatioShouldCalculateRatioOfVolumesWithDefaultParameter() {
        Volume volume = new Volume();

        double result = volume.volumeRatio(SPHERE);

        Assert.assertEquals(3.07, result, DELTA);
    }
}
