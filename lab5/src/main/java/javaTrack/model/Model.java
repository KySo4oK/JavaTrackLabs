package javaTrack.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

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

    public Animal[] getAnimalsByMinAge(int minAge) {
        log.info("minAge - {}", minAge);
        int quantity = getQuantityOfAnimalsByParameters(minAge);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if (animal.getAge() >= minAge) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
        this.currentAnimals = animalsByParameter;
        return animalsByParameter;
    }

    private int getQuantityOfAnimalsByParameters(int minAge) {
        int quantity = 0;
        for (Animal animal : animals) {
            if (animal.getAge() >= minAge) {
                quantity++;
            }
        }
        return quantity;
    }

    public Animal[] getAnimalsByFamily(String family) {
        log.info("family - {}", family);
        int quantity = getQuantityOfAnimalsByParameters(family);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if (animal.getFamily().equals(family)) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
        this.currentAnimals = animalsByParameter;
        return animalsByParameter;
    }

    private int getQuantityOfAnimalsByParameters(String family) {
        int quantity = 0;
        for (Animal animal : animals) {
            if (animal.getFamily().equals(family)) {
                quantity++;
            }
        }
        return quantity;
    }

    public Animal[] getAnimalsByAgeAndColoring(int age, String coloring) {
        log.info("age - {}, coloring - {}", age, coloring);
        int quantity = getQuantityOfAnimalsByParameters(age, coloring);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if ((animal.getColoring().equals(coloring)) && (animal.getAge() == age)) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
        this.currentAnimals = animalsByParameter;
        return animalsByParameter;
    }

    private int getQuantityOfAnimalsByParameters(int age, String coloring) {
        int quantity = 0;
        for (Animal animal : animals) {
            if ((animal.getColoring().equals(coloring))
                    && (animal.getAge() == age)) {
                quantity++;
            }
        }
        return quantity;
    }

    public String[] getFamilies() {
        ArrayList<String> families = new ArrayList<>();
        for (Animal animal : animals) {
            if (families.indexOf(animal.getFamily()) == -1) {
                families.add(animal.getFamily());
            }
        }
        String[] familiesArray = new String[families.size()];
        for (int i = 0; i < families.size(); i++) {
            familiesArray[i] = families.get(i);
        }
        return familiesArray;
    }

    public String[] getColorings() {
        ArrayList<String> colorings = new ArrayList<>();
        for (Animal animal : animals) {
            if (colorings.indexOf(animal.getColoring()) == -1) {
                colorings.add(animal.getColoring());
            }
        }
        String[] coloringsArray = new String[colorings.size()];
        for (int i = 0; i < colorings.size(); i++) {
            coloringsArray[i] = colorings.get(i);
        }
        return coloringsArray;
    }

    public void saveCurrentAnimalsToFile(String filePath) throws IOException {
        dataSource.saveAnimals(currentAnimals, filePath);
    }

    public boolean isCurrentAnimalsEmpty() {
        return currentAnimals == null;
    }
}
