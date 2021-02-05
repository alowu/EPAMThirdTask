package com.epam.task.third.repository;

import com.epam.task.third.entities.Sphere;
import com.epam.task.third.sort.Sort;
import com.epam.task.third.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SphereRepository implements Sort, Repository{
    private static SphereRepository REPOSITORY;
    private List<Sphere> list = new ArrayList<>();

    private SphereRepository(){};

    public static SphereRepository getRepository(){
        if (REPOSITORY == null) {
            REPOSITORY = new SphereRepository();
        }
        return REPOSITORY;
    }

    public List<Sphere> getList() {
        return list;
    }

    @Override
    public void addSphere(Sphere sphere) {
        list.add(sphere);
    }

    @Override
    public void removeSphere(Sphere sphere) {
        list.remove(sphere);
    }

    @Override
    public void updateSphere(Sphere sphere) {
        int id = sphere.getID();
        for (Sphere figure : list) {
            if (id == figure.getID()) {
                list.remove(figure);
                list.add(sphere);
            }
        }
    }

    @Override
    public List<Sphere> query(Specification specification) {
        List<Sphere> newList = new ArrayList<>();
        for (Sphere figure : list) {
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
