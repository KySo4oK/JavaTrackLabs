package javaTrack.view;

import javaTrack.model.Animal;
import javaTrack.model.DataSource;

public class View {
    public String[] families;
    public String[] colorings;

    public View() {
        this.families = DataSource.getFamilies();
        this.colorings = DataSource.getColorings();
    }

    public void printMainMenu() {
        printMessage(TextConstant.PRINT_INDEX);
        printMessage(TextConstant.PRINT_BY_MIN_AGE);
        printMessage(TextConstant.PRINT_BY_FAMILY);
        printMessage(TextConstant.PRINT_BY_AGE_AND_COLORING);
        printMessage(TextConstant.EXIT);
    }

    public void printWrongInputMessage() {
        printMessage(TextConstant.WRONG_INPUT);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printFindByFamilyMenu() {
        printMessage(TextConstant.PRINT_INDEX_OF_FAMILY);
        for (int i = 0; i < families.length; i++) {
            printMessage(i + ". " + families[i]);
        }
    }

    public void printAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println("type='" + animal.getType() + '\'' +
                    ", family='" + animal.getFamily() + '\'' +
                    ", lineage='" + animal.getLineage() + '\'' +
                    ", kind='" + animal.getKind() + '\'' +
                    ", subspecies='" + animal.getSubspecies() + '\'' +
                    ", coloring='" + animal.getColoring() + '\'' +
                    ", age=" + animal.getAge());
        }
    }

    public void printFindByMinAgeMenu() {
        printMessage(TextConstant.PRINT_MIN_AGE);
    }

    public void printAgeMenu() {
        printMessage(TextConstant.PRINT_AGE);
    }

    public void printFindByColoringMenu() {
        printMessage(TextConstant.PRINT_INDEX_OF_COLORING);
        for (int i = 0; i < colorings.length; i++) {
            printMessage(i + ". " + colorings[i]);
        }
    }
}
