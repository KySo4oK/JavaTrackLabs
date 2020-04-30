package javaTrack.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataSource {
    private static final String FILE = "data.json";

    public Animal[] getAnimals() {
        Animal[] animals = new Animal[10];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal("type" + i,
                    "classOfAnimals" + i,
                    "family" + i % 3,
                    "lineage" + i,
                    "kind" + i,
                    "subspecies" + i,
                    i % 3 + 1,
                    "coloring" + i % 3);
        }
        return animals;
    }

    public Animal[] getAnimalsFromFile() {
        Animal[] animals = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            animals = mapper.readValue(new File(FILE), Animal[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public void saveAnimals(Animal[] animals, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), animals);
    }
}
