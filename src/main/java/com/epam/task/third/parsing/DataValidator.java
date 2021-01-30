package com.epam.task.third.parsing;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class DataValidator {

    private final static Logger LOG = Logger.getLogger(DataValidator.class);

    private final String invalidSymbols = "[a-zA-Z!?,:;]";
    private final String correctFormatNumber = "^[+-]?[0-9]+(?:[.][0-9]{1,2})*$";
    private final String delimiter = " ";

    public boolean isContainInvalid(String string) {
        return string.matches(invalidSymbols);
    }

    public boolean isContainCorrectNumber(String string) {
        return string.matches(correctFormatNumber);
    }

    public boolean isValid(String string) {
        String[] elements = string.split(delimiter);
        if (elements.length == 4){
            for (String element : elements) {
                if (!isContainCorrectNumber(element) || isContainInvalid(string)) {
                    return false;
                }
            }
        }
        return true;
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
        return result;
    }
}
