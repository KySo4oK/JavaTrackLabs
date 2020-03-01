package javaTrack.view;

import javaTrack.model.Animal;

public class View {
    public String[] families;
    public String[] colorings;

    public void printMainMenu() {

    }

    public void printWrongInputMessage() {
        printMessage(TextConstant.WRONG_INPUT);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printFindByFamilyMenu() {
    }

    public void printAnimals(Animal[] animalsByFamily) {
    }

    public void printFindByMinAgeMenu() {
    }

    public void printAgeMenu() {

    }
}
