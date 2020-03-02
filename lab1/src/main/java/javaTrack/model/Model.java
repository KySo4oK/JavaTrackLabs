package javaTrack.model;

public class Model {
    public Model() {
        this.animals = DataSource.getAnimals();
    }

    private Animal[] animals;

    public Animal[] getAnimalsByMinAge(int minAge) {
        int quantity = getQuantityOfAnimalsByParameters(minAge);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if (animal.getAge() >= minAge) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
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
        int quantity = getQuantityOfAnimalsByParameters(family);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if (animal.getFamily().equals(family)) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
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
        int quantity = getQuantityOfAnimalsByParameters(age, coloring);
        Animal[] animalsByParameter = new Animal[quantity];
        int index = 0;
        for (Animal animal : animals) {
            if ((animal.getColoring().equals(coloring)) && (animal.getAge() == age)) {
                animalsByParameter[index] = animal;
                index++;
            }
        }
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

}
