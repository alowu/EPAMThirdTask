package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class SpherePropertiesTest {

    private final double RADIUS = 5;
    private final Sphere NOT_SPHERE = new Sphere(new Dot(), 0);

    private final Dot TOUCH_AXES = new Dot(RADIUS, RADIUS, RADIUS);
    private final Dot DONT_TOUCH = new Dot();

    private final Sphere SPHERE_T = new Sphere(TOUCH_AXES, RADIUS);
    private final Sphere SPHERE_DT = new Sphere(DONT_TOUCH, RADIUS);


    @Test
    public void testIsSphereShouldReturnTrueWhenRadiusIsPositive() {
        SphereProperties property = new SphereProperties();

        boolean result = property.isSphere(SPHERE_T);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsSphereShouldReturnFalseWhenRadiusIsZero() {
        SphereProperties property = new SphereProperties();

        boolean result = property.isSphere(NOT_SPHERE);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsTouchAxes() {
        SphereProperties property = new SphereProperties();

        boolean result = property.isTouchAxes(SPHERE_T);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsDontTouchAxes() {
        SphereProperties property = new SphereProperties();

        boolean result = property.isTouchAxes(SPHERE_DT);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsCrossAxeShouldReturnTrueWhenCross() {
        SphereProperties property = new SphereProperties();

        boolean result = property.isCrossAxe(0 ,SPHERE_DT);

        Assert.assertTrue(result);
    }
}
