package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class PropertiesTest {

    private final double RADIUS = 5;
    private final Sphere SPHERE = new Sphere(new Dot(), RADIUS);
    private final Sphere NOT_SPHERE = new Sphere(new Dot(), 0);

    @Test
    public void testIsSphereShouldReturnTrueWhenRadiusIsPositive() {
        Properties property = new Properties();

        boolean result = property.isSphere(SPHERE);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsSphereShouldReturnFalseWhenRadiusIsZero() {
        Properties property = new Properties();

        boolean result = property.isSphere(NOT_SPHERE);

        Assert.assertFalse(result);
    }
}
