package com.epam.task.third.repository;

import com.epam.task.third.entities.Sphere;
import com.epam.task.third.specification.Specification;

import java.util.List;

public interface Repository {
    void addSphere(Sphere sphere);
    void removeSphere(Sphere sphere);
    void updateSphere(Sphere sphere);
    List<Sphere> query(Specification specification);
}
