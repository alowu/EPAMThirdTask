package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

public class SphereProperties {

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

        boolean touchOx = touchAxe(z, r);
        boolean touchOy = touchAxe(x, r);
        boolean touchOz = touchAxe(y, r);

        return touchOx || touchOy || touchOz;
    }

    private boolean touchAxe(double coordinate, double radius) {
        double delta = radius - Math.abs(coordinate);
        return delta == 0;
    }

    public boolean isCrossAxe(double coordinateOfCenter, Sphere sphere){
        double radius = sphere.getRadius();
        double delta = radius - Math.abs(coordinateOfCenter);
        return delta > 0;
    }
}
