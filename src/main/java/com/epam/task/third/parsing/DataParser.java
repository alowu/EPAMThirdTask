package com.epam.task.third.parsing;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class DataParser {

    private final static Logger LOG = Logger.getLogger(DataParser.class);

    private final String delimiter = " ";

    private Double[] getDataFromLine(String[] line) {
        Double[] numbers = new Double[line.length];
        for (int i = 0; i < line.length; ++i) {
            numbers[i] = Double.parseDouble(line[i]);
        }
        return numbers;
    }

    public Double[][] parse(ArrayList<String> data){
        LOG.info("Start parsing data");
        int amountOfSpheres = data.size();
        Double[][] result = new Double[amountOfSpheres][4];
        int position = 0;
        for (String line : data) {
            String[] buffer = line.split(delimiter);
            result[position] = getDataFromLine(buffer);
            ++position;
        }
        LOG.info("Data was parsed");
        return result;
    }

}
