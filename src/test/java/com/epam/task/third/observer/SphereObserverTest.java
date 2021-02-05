package com.epam.task.third.observer;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.observe.SphereObservable;
import com.epam.task.third.observe.SphereObserver;
import com.epam.task.third.parameters.SphereParameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class SphereObserverTest {
    private final SphereObserver OBSERVER = SphereObserver.getObserver();
    private final SphereObservable SPHERE = new SphereObservable(new Dot(), 1, 0);

    @Test
    public void testUpdateShouldObservedChangesWhenSphereObservableElementApplied() {
        SPHERE.addObserver(OBSERVER);

        Map<Integer, SphereParameters> stage1 = OBSERVER.getParametersMap();
        String old = stage1.toString();
        SPHERE.setRadius(10);
        Map<Integer, SphereParameters> stage2 = OBSERVER.getParametersMap();
        String current = stage2.toString();

        Assert.assertNotEquals(old, current);
    }
}
