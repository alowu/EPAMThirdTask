package com.epam.task.third.repository;

import com.epam.task.third.observe.SphereObservable;
import com.epam.task.third.sort.Sort;
import com.epam.task.third.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SphereRepository implements Sort, Repository{
    private static SphereRepository REPOSITORY;
    private List<SphereObservable> list = new ArrayList<>();

    private SphereRepository(){};

    public static SphereRepository getRepository(){
        if (REPOSITORY == null) {
            REPOSITORY = new SphereRepository();
        }
        return REPOSITORY;
    }

    public List<SphereObservable> getList() {
        return list;
    }

    @Override
    public void addSphere(SphereObservable sphere) {
        list.add(sphere);
    }

    @Override
    public void removeSphere(SphereObservable sphere) {
        list.remove(sphere);
    }

    @Override
    public void updateSphere(SphereObservable sphere) {
        int id = sphere.getID();
        for (SphereObservable figure : list) {
            if (id == figure.getID()) {
                list.remove(figure);
                list.add(sphere);
            }
        }
    }

    @Override
    public List<SphereObservable> query(Specification specification) {
        List<SphereObservable> newList = new ArrayList<>();
        for (SphereObservable figure : list) {
            if (specification.specified(figure)){
                newList.add(figure);
            }
        }
        return newList;
    }

    @Override
    public void sort(Comparator comparator) {
        list.sort(comparator);
    }
}
