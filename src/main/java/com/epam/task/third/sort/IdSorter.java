package com.epam.task.third.sort;

import com.epam.task.third.observe.SphereObservable;

import java.util.Comparator;

public class IdSorter implements Comparator<SphereObservable> {

    @Override
    public int compare(SphereObservable s1, SphereObservable s2) {
        int id1 = s1.getId();
        int id2 = s2.getId();
        return Integer.compare(id1, id2);
    }
}
