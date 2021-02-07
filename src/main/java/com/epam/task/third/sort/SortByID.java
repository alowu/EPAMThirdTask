package com.epam.task.third.sort;

import com.epam.task.third.observe.SphereObservable;

import java.util.Comparator;

public class SortByID implements Comparator<SphereObservable> {

    @Override
    public int compare(SphereObservable s1, SphereObservable s2) {
        int id1 = s1.getID();
        int id2 = s2.getID();
        return Integer.compare(id1, id2);
    }
}
