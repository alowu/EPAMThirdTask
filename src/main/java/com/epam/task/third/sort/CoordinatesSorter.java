package com.epam.task.third.sort;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.observe.SphereObservable;

import java.util.Comparator;

public class CoordinatesSorter implements Comparator<SphereObservable> {
    @Override
    public int compare(SphereObservable s1, SphereObservable s2) {
        Dot center1 = s1.getCenter();
        Dot center2 = s2.getCenter();

        double x1 = center1.getX();
        double x2 = center2.getX();
        return Double.compare(x1, x2);
    }
}
