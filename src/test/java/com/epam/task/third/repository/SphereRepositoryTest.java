package com.epam.task.third.repository;

import com.epam.task.third.entities.Dot;
import com.epam.task.third.entities.Sphere;
import com.epam.task.third.sort.SortByCoordinates;
import com.epam.task.third.sort.SortByID;
import com.epam.task.third.specification.SpecificationByArea;
import com.epam.task.third.specification.SpecificationByVolume;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SphereRepositoryTest {
    private final static SphereRepository REPOSITORY = SphereRepository.getRepository();
    private final static List<Sphere> SPHERES = Arrays.asList(
            new Sphere(new Dot(0, 0, 0), 2, 4),
            new Sphere(new Dot(10, 0, 0), 4, 2),
            new Sphere(new Dot(-5, 0, 0), 6, 1),
            new Sphere(new Dot(5, 0, 0), 8, 3)
    );
    private final List<Sphere> EXPECTED = Arrays.asList(
            new Sphere(new Dot(-5, 0, 0), 6, 1),
            new Sphere(new Dot(5, 0, 0), 8, 3)
    );
    private final List<Sphere> EXPECTED_ID = Arrays.asList(
            new Sphere(new Dot(-5, 0, 0), 6, 1),
            new Sphere(new Dot(10, 0, 0), 4, 2),
            new Sphere(new Dot(5, 0, 0), 8, 3),
            new Sphere(new Dot(0, 0, 0), 2, 4)
    );
    private final List<Sphere> EXPECTED_COORDINATE = Arrays.asList(
            new Sphere(new Dot(-5, 0, 0), 6, 1),
            new Sphere(new Dot(0, 0, 0), 2, 4),
            new Sphere(new Dot(5, 0, 0), 8, 3),
            new Sphere(new Dot(10, 0, 0), 4, 2)
    );

    @BeforeClass
    public static void loadData(){
        for (Sphere sphere : SPHERES){
            REPOSITORY.addSphere(sphere);
        }
    }

    @Test
    public void testQueryShouldReturnListSpecifiedByAreaWhenOvalsApplied() {
        SpecificationByArea byArea = new SpecificationByArea(250.);

        List<Sphere> result = REPOSITORY.query(byArea);

        Assert.assertEquals(EXPECTED, result);
    }

    @Test
    public void testQueryShouldReturnListSpecifiedByVolumeWhenOvalsApplied() {
        SpecificationByVolume byVolume = new SpecificationByVolume(600.);

        List<Sphere> result = REPOSITORY.query(byVolume);

        Assert.assertEquals(EXPECTED, result);
    }

    @Test
    public void testQueryShouldReturnListSortedByIDWhenOvalsApplied(){
        SortByID byID = new SortByID();

        REPOSITORY.sort(byID);
        List<Sphere> result = REPOSITORY.getList();

        Assert.assertEquals(EXPECTED_ID, result);
    }

    @Test
    public void testQueryShouldReturnListSortedByCoordinateWhenOvalsApplied(){
        SortByCoordinates byX = new SortByCoordinates();

        REPOSITORY.sort(byX);
        List<Sphere> result = REPOSITORY.getList();

        Assert.assertEquals(EXPECTED_COORDINATE, result);
    }
}
