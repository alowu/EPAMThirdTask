package com.epam.task.third.parsing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DataParserTest {

    private final ArrayList<String> TEST_DATA = new ArrayList<>(
            Arrays.asList("-121.2 -113.4 450.5 3.4"
                        , "3.14 15 9 2.6"));

    private final Double[][] EXPECTED = {{-121.2, -113.4, 450.5, 3.4},
                                         {3.14, 15., 9., 2.6}};

    @Test
    public void testParseShouldParseDataStrings() {
        DataParser parser = new DataParser();

        Double[][] result = parser.parse(TEST_DATA);

        Assert.assertArrayEquals(EXPECTED, result);
    }
}
