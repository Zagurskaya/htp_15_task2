package com.zagurskaya.task2.reader;

import com.zagurskaya.task2.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataReader {
    static final Logger logger = LogManager.getLogger(DataReader.class);

    public String readText(String fileName) throws ProjectException {
        File file;
        String text;
        try {
            file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        } catch (NullPointerException e) {
            logger.log(Level.ERROR, "Problems with the path to file", e);
            throw new ProjectException("Problems with the path to file", e);
        }
        text = readTextFromFile(file);
        return text;

    }

    private String readTextFromFile(File path) {
        StringBuilder builder = new StringBuilder();
        String text;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().filter(line -> !line.isEmpty()).forEachOrdered(s -> builder.append(s).append("\n"));
            text = builder.toString().trim();
            return text;
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "file not found", e);
            throw new ProjectException("file not found", e);

        } catch (IOException e) {
            logger.log(Level.ERROR, "Problems with the path to file", e);
            throw new ProjectException("Problems with the path to file", e);
        }
    }


}
