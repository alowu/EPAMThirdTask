package com.epam.task.third.observe;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereObservable extends Sphere implements Observable {

    private List<Observer> observers = new ArrayList<>();

    public SphereObservable(Dot center, double radius, Integer ID) {
        super(center, radius, ID);
    }

    @Override
    public void setCenter(Dot center){
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius){
        super.setRadius(radius);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
