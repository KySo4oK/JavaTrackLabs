package javaTrack.model;

import java.util.ArrayList;

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
}
