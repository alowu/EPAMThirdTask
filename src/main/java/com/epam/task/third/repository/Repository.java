package com.epam.task.third.repository;

import com.epam.task.third.observe.SphereObservable;
import com.epam.task.third.specification.Specification;

import java.util.List;

public interface Repository {
    void add(SphereObservable sphere);
    void removeSphere(SphereObservable sphere);
    void updateSphere(SphereObservable sphere);
    List<SphereObservable> query(Specification specification);
}
