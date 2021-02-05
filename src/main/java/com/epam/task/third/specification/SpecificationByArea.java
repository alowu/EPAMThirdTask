package com.epam.task.third.specification;

import com.epam.task.third.entities.Sphere;
import com.epam.task.third.logic.SphereLogic;

public class SpecificationByArea implements Specification{
    private double area;
    private SphereLogic calculator = new SphereLogic();

    public SpecificationByArea(double area) {
        this.area = area;
    }

    @Override
    public Boolean specified(Sphere sphere) {
        double area = calculator.calculateSquare(sphere);
        return area >= this.area;
    }
}
