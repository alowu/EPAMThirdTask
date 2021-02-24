package com.epam.task.third.repository;

import com.epam.task.third.observe.SphereObservable;
import com.epam.task.third.sort.Sorter;
import com.epam.task.third.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SphereRepository implements Sorter, Repository{
    private SphereRepository REPOSITORY;
    private List<SphereObservable> list = new ArrayList<>();

    SphereRepository(){};

    public SphereRepository getRepository(){
        return REPOSITORY;
    }

    public List<SphereObservable> getList() {
        return list;
    }

    @Override
    public void add(SphereObservable sphere) {
        list.add(sphere);
    }

    @Override
    public void removeSphere(SphereObservable sphere) {
        list.remove(sphere);
    }

    @Override
    public void updateSphere(SphereObservable sphere) {
        int id = sphere.getId();
        for (SphereObservable figure : list) {
            if (id == figure.getId()) {
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
