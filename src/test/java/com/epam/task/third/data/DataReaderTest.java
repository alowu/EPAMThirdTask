package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DataReaderTest {

    private final String fileName = "src/test/java/resources/input.txt";

    private final ArrayList<String> EXPECTED = new ArrayList<>(
            Arrays.asList("-121.2 -113.4 450.5 3.4"
                    , "123.31.155 541 57 354"
                    , "1 2 3 -4"
                    , "1 2 3g -4"));

    private final String nonExistentFileName = "resources/null.txt";

    @Test
    public void testGetDataShouldThrowDataException() {
        DataReader reader = new DataReader();

        Assert.assertThrows(DataException.class, () -> {reader.getData(nonExistentFileName);});
    }

    @Test
    public void testGetDataShouldGetDataFromFile() throws DataException {
        DataReader reader = new DataReader();

        ArrayList<String> result = reader.getData(fileName);

        Assert.assertEquals(EXPECTED, result);
    }
}
