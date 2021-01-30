package com.epam.task.third.data;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    private final static Logger LOG = Logger.getLogger(DataReader.class);

    private void closeReaders(FileReader fileReader, BufferedReader reader) {
        try {
            fileReader.close();
            reader.close();
            LOG.info("Readers are closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getData(String fileName) throws DataException {
        FileReader fileReader;
        BufferedReader reader;

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
        } catch (IOException e) {
            throw new DataException(e.getMessage() + " 404", e);
        }

        LOG.info("Getting data from " + fileName);

        ArrayList<String> result = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            closeReaders(fileReader, reader);
        }

        LOG.info("Got data from " + fileName);

        return result;
    }
}
