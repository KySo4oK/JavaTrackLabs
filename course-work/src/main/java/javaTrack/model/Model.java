package javaTrack.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

public class Model {
    private static final Logger log = LogManager.getLogger(Model.class);

    public Model() throws IOException {
        this.animals = dataSource.getAnimalsFromFile();
    }

    public Animal[] getAnimals() {
        return animals;
    }

    private Animal[] animals;
    private Animal[] currentAnimals;
    private DataSource dataSource = new DataSource();

    public Animal[] getAnimalsByMinAge(final int minAge) {
        log.info("minAge - {}", minAge);
        this.currentAnimals = Arrays.stream(animals)
                .filter(a -> a.getAge() >= minAge)
                .toArray(Animal[]::new);
        return currentAnimals;
    }

    public Animal[] getAnimalsByFamily(String family) {
        log.info("family - {}", family);
        this.currentAnimals = Arrays.stream(animals)
                .filter(a -> a.getFamily().equals(family))
                .toArray(Animal[]::new);
        return currentAnimals;
    }

    public Animal[] getAnimalsByTypeAndColoring(String type, String coloring) {
        log.info("type - {}, coloring - {}", type, coloring);
        this.currentAnimals = Arrays.stream(animals)
                .filter(a -> a.getColoring().equals(coloring) && a.getType().equals(type))
                .toArray(Animal[]::new);
        return currentAnimals;
    }

    public String[] getFamilies() {
        return Arrays.stream(animals)
                .map(Animal::getFamily)
                .distinct()
                .toArray(String[]::new);
    }

    public String[] getColorings() {
        return Arrays.stream(animals)
                .map(Animal::getColoring)
                .distinct()
                .toArray(String[]::new);
    }

    public void saveCurrentAnimalsToFile(String filePath) throws IOException {
        dataSource.saveAnimals(currentAnimals, filePath);
    }

    public boolean isCurrentAnimalsEmpty() {
        return currentAnimals == null;
    }

    public String[] getTypes() {
        return Arrays.stream(animals)
                .map(Animal::getType)
                .distinct()
                .toArray(String[]::new);
    }
}
