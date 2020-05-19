package javaTrack.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataSource {
    private static final String FILE = "data.json";

    public Animal[] getAnimalsFromFile() throws IOException {
        return new ObjectMapper().readValue(new File(FILE), Animal[].class);
    }

    public void saveAnimals(Animal[] animals, String filePath) throws IOException {
        new ObjectMapper().writeValue(new File(filePath), animals);
    }
}
