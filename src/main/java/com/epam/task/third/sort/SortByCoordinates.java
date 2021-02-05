package com.epam.task.third.sort;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

import java.util.Comparator;

public class SortByCoordinates implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        Dot center1 = s1.getCenter();
        Dot center2 = s2.getCenter();

        double x1 = center1.getX();
        double x2 = center2.getX();
        return Double.compare(x1, x2);
    }
}
