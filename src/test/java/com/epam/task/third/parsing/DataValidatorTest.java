package com.epam.task.third.parsing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DataValidatorTest {

    private final ArrayList<String> TEST_DATA = new ArrayList<>(
                Arrays.asList("-121.2 -113.4 450.5 3.4"
                            , "123.31.155 541 57 354"
                            , "1 2 3 -4"
                            , "1 2 3g -4"));

    private final ArrayList<String> EXPECTED = new ArrayList<>(
                Arrays.asList("-121.2 -113.4 450.5 3.4"
                            ,"1 2 3 -4"));

    private final ArrayList<String> EMPTY_DATA = new ArrayList<>();

    @Test
    public void testValidatorShouldReturnValidateData() {
        DataValidator validator = new DataValidator();

        ArrayList<String> result = validator.validate(TEST_DATA);

        Assert.assertEquals(EXPECTED, result);
    }

    @Test
    public void testValidatorShouldReturnEmptyArrayList() {
        DataValidator validator = new DataValidator();

        ArrayList<String> result = validator.validate(EMPTY_DATA);

        Assert.assertEquals(EMPTY_DATA, result);
    }
}
