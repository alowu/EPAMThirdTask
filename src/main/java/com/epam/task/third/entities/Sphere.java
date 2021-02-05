package com.epam.task.third.entities;

import java.util.Objects;

public class Sphere {
    private final Integer ID;
    private Dot center;
    private double radius;

    public Sphere(Dot center, double radius, Integer ID) {
        this.center = center;
        this.radius = radius;
        this.ID = ID;
    }

    public Dot getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public Integer getID() {
        return ID;
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
        return Double.compare(sphere.getRadius(), getRadius()) == 0 && getID().equals(sphere.getID()) && getCenter().equals(sphere.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCenter(), getRadius());
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "ID=" + ID +
                ", center=" + center +
                ", radius=" + radius +
                '}';
    }
}
