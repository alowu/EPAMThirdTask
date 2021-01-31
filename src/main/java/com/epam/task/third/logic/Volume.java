package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

public class Volume implements Processor {

    @Override
    public double calculate(Sphere sphere) {
        final double radius = sphere.getRadius();
        final double volume = 4 / 3. * Math.PI * radius * radius * radius;
        return volume;
    }

    public double calculate(Sphere sphere, double point) {
        final double radius = sphere.getRadius();
        final double delta = radius - Math.abs(point);
        final double volume = delta * delta * Math.PI / 3. * (3 * radius - delta);
        return volume;
    }

    public double volumeRatio(Sphere sphere){
        return volumeRatio(sphere, 'x');
    }

    public double volumeRatio(Sphere sphere, char axe) {
        SphereProperties properties = new SphereProperties();

        Dot center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();

        double ratio = -1.;
        switch (axe){
            case 'x':{
                if (properties.isCrossAxe(z, sphere)){
                    ratio = findValue(sphere, x);
                }
                break;
            }
            case 'y':{
                if (properties.isCrossAxe(x, sphere)){
                    ratio = findValue(sphere, y);
                }
                break;
            }
            case 'z':{
                if (properties.isCrossAxe(y, sphere)){
                    ratio = findValue(sphere, z);
                }
                break;
            }
        }
        return ratio;
    }

    private double findValue(Sphere sphere, double point){
        Volume volume = new Volume();

        double half_1 = volume.calculate(sphere, point);
        double common = volume.calculate(sphere);
        double half_2 = common - half_1;

        return half_2 / half_1;
    }
}
