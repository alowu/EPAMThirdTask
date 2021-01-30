package com.epam.task.third.logic;

import com.epam.task.third.entities.Sphere;

public class Square implements Processor{

    @Override
    public double calculate(Sphere sphere) {
        double radius = sphere.getRadius();
        double square = 4 * Math.PI * radius * radius;
        return square;
    }
}
