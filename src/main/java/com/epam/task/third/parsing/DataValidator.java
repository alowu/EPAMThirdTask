package com.epam.task.third.parsing;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class DataValidator {

    private final static Logger LOG = Logger.getLogger(DataValidator.class);

    private final String invalidSymbols = "[a-zA-Z!?,:;]";
    private final String correctFormatNumber = "^[+-]?[0-9]+(?:[.][0-9]{1,2})*$";
    private final String radiusCannotBeNegative = "^[+]?[0-9]+(?:[.][0-9]{1,2})*$";
    private final String delimiter = " ";
    private final int radiusPosition = 4;

    public boolean isContainInvalid(String number) {
        return number.matches(invalidSymbols);
    }

    public boolean isCorrectFormat(String number) {
        return number.matches(correctFormatNumber);
    }

    public boolean isRadiusNotNegative(String radius) {
        return radius.matches(radiusCannotBeNegative);
    }

    public boolean isValid(String string) {
        String[] elements = string.split(delimiter);
        boolean valid = true;
        if (elements.length == 4){
            for (String element : elements) {
                if (!isCorrectFormat(element) || isContainInvalid(string)) {
                    valid = false;
                }
            }
            if (valid) {
                valid = isRadiusNotNegative(elements[radiusPosition - 1]);
            }
        }
        return valid;
    }

    public ArrayList<String> validate(ArrayList<String> data) {
        LOG.info("Start lines validation");
        ArrayList<String> result = new ArrayList<>();
        int numberOfLine = 1;
        for (String line : data) {
            if (isValid(line)) {
                result.add(line);
                LOG.info("The " + numberOfLine + " line is valid");
            }
            ++numberOfLine;
        }
        LOG.info("Lines was validated");
        return result;
    }
}
