package com.epam.task.third.parameters;

import java.util.Objects;

public class SphereParameters {
    private double area;
    private double volume;

    public SphereParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SphereParameters that = (SphereParameters) o;
        return Double.compare(that.getArea(), getArea()) == 0 && Double.compare(that.getVolume(), getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea(), getVolume());
    }

    @Override
    public String toString() {
        return "SphereParameters{" +
                "area=" + area +
                ", volume=" + volume +
                '}';
    }
}
