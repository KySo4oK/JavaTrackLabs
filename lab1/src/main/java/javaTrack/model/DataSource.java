package javaTrack.model;

import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DataSource {
    static Animal[] getAnimals() {
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

    public static void saveAnimals(Animal[] animals) {
        JSONArray jsonAnimals = getJsonArrayOfArray(animals);
        writeToFile(jsonAnimals);
    }

    private static JSONArray getJsonArrayOfArray(Animal[] animals) {
        JSONArray jsonAnimals = new JSONArray();
        jsonAnimals.addAll(Arrays.asList(animals));
        return jsonAnimals;
    }

    private static void writeToFile(JSONArray jsonAnimals) {
        try (FileWriter file = new FileWriter("data.json")) {

            file.write(jsonAnimals.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
