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
        //given
        SPHERE.addObserver(OBSERVER);
        Map<Integer, SphereParameters> old = OBSERVER.getParametersMap();
        String previous = old.toString();

        //when
        SPHERE.setRadius(10);
        Map<Integer, SphereParameters> changed = OBSERVER.getParametersMap();
        String current = changed.toString();

        //then
        Assert.assertNotEquals(previous, current);
    }
}
