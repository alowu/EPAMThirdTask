package com.epam.task.third.entities;

import java.util.Objects;

public class Sphere {
    private Dot center;
    private double radius;

    public Sphere(Dot center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Dot getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Dot center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.getRadius(), getRadius()) == 0 && getCenter().equals(sphere.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter(), getRadius());
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
