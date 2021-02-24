package com.epam.task.third.observe;

import com.epam.task.third.logic.SphereLogic;
import com.epam.task.third.parameters.SphereParameters;

import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer {
    private static SphereObserver OBSERVER;
    private SphereLogic logic = new SphereLogic();
    private Map<Integer, SphereParameters> parametersMap = new HashMap<>();

    private SphereObserver(){}

    public static SphereObserver getObserver() {
        if (OBSERVER == null) {
            OBSERVER = new SphereObserver();
        }
        return OBSERVER;
    }

    public Map<Integer, SphereParameters> getParametersMap() {
        return parametersMap;
    }

    @Override
    public void update(SphereObservable sphere) {
        double area = logic.calculateSquare(sphere);
        double volume = logic.calculateVolume(sphere);
        SphereParameters parameters = new SphereParameters(area, volume);
        parametersMap.put(sphere.getId(), parameters);
    }
}
