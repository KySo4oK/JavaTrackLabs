package javaTrack.model;

import java.util.ArrayList;

public class DataSource {
    public static Animal[] getAnimals() {
        Animal[] animals = new Animal[10];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal("type" + i,
                    "classOfAnimals" + i,
                    "family" + i,
                    "lineage" + i,
                    "kind" + i,
                    "subspecies" + i,
                    i,
                    "coloring" + i);
        }
        return animals;
    }

    public static String[] getFamilies() {
        Animal[] animals = getAnimals();
        ArrayList<String> families = new ArrayList<>();
        for (Animal animal : animals) {
            if (families.indexOf(animal.getFamily()) != -1) {
                families.add(animal.getFamily());
            }
        }
        return (String[]) families.toArray();
    }

    public static String[] getColorings() {
        Animal[] animals = getAnimals();
        ArrayList<String> colorings = new ArrayList<>();
        for (Animal animal : animals) {
            if (colorings.indexOf(animal.getColoring()) != -1) {
                colorings.add(animal.getColoring());
            }
        }
        return (String[]) colorings.toArray();
    }
}
