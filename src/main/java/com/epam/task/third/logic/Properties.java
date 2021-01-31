package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

public class Properties {

    public boolean isSphere(Sphere sphere) {
        double radius = sphere.getRadius();
        return radius > 0;
    }

    public boolean isTouchAxes(Sphere sphere) {
        Dot center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        double r = sphere.getRadius();

        boolean touchOx = touchAxe(x, r);
        boolean touchOy = touchAxe(y, r);
        boolean touchOz = touchAxe(z, r);

        return touchOx || touchOy || touchOz;
    }

    public boolean touchAxe(double coordinate, double radius) {
        double delta = Math.abs(coordinate - radius);
        return delta == 0 || delta == 2 * radius;
    }
}
