package com.epam.task.third.sort;

import com.epam.task.third.entities.Sphere;

import java.util.Comparator;

public class SortByID implements Comparator<Sphere> {

    @Override
    public int compare(Sphere s1, Sphere s2) {
        int id1 = s1.getID();
        int id2 = s2.getID();
        return Integer.compare(id1, id2);
    }
}
