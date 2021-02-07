package com.epam.task.third.specification;

import com.epam.task.third.logic.SphereLogic;
import com.epam.task.third.observe.SphereObservable;

public class SpecificationByVolume implements Specification{
    private double volume;
    private SphereLogic calculator = new SphereLogic();

    public SpecificationByVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public Boolean specified(SphereObservable sphere) {
        double volume = calculator.calculateVolume(sphere);
        return volume >= this.volume;
    }
}
