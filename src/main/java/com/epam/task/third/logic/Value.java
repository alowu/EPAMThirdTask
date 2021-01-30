package com.epam.task.third.logic;

import com.epam.task.third.entities.Sphere;

public class Value implements Processor {

    @Override
    public double calculate(Sphere sphere) {
        double radius = sphere.getRadius();
        double value = 4 / 3. * Math.PI * radius * radius * radius;
        return value;
    }
}
