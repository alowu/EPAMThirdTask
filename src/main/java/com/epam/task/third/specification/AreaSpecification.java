package com.epam.task.third.specification;

import com.epam.task.third.logic.SphereLogic;
import com.epam.task.third.observe.SphereObservable;

public class AreaSpecification implements Specification{
    private double area;
    private SphereLogic calculator = new SphereLogic();

    public AreaSpecification(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(SphereObservable sphere) {
        double area = calculator.calculateSquare(sphere);
        return area >= this.area;
    }
}
