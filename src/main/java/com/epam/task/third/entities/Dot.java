package com.epam.task.third.entities;

import java.util.Objects;

public class Dot {
    private final double x;
    private final double y;
    private final double z;

    public Dot(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return getX() == dot.getX() && getY() == dot.getY() && getZ() == dot.getZ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
