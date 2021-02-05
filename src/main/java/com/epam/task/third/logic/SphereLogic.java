package com.epam.task.third.logic;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

public class SphereLogic {

    public double calculateSquare(Sphere sphere){
        double radius = sphere.getRadius();
        return 4 * Math.PI * radius * radius;
    }

    public double calculateVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        return 4 / 3. * Math.PI * radius * radius * radius;
    }

    public double calculateVolume(Sphere sphere, double point) {
        double radius = sphere.getRadius();
        double delta = radius - Math.abs(point);
        return delta * delta * Math.PI / 3. * (3 * radius - delta);
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
        double half_1 = calculateVolume(sphere, point);
        double common = calculateVolume(sphere);
        double half_2 = common - half_1;

        return half_2 / half_1;
    }
}
