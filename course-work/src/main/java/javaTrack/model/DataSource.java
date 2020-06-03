package javaTrack.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DataSource {
    private static final Logger log = LogManager.getLogger(DataSource.class);
    private static final String FILE = "data.json";

    public Animal[] getAnimalsFromFile() throws IOException {
        return new ObjectMapper().readValue(new File(FILE), Animal[].class);
    }

    public void saveAnimals(Animal[] animals, String filePath) throws IOException {
        log.info("length of result - {}", animals.length);
        log.info("filePath - {}", filePath);
        new ObjectMapper().writeValue(new File(filePath), animals);
    }
}
