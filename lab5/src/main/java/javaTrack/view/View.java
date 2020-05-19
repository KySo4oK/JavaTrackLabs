package javaTrack.view;

import javaTrack.model.Animal;
import javaTrack.model.DataSource;

import java.util.Locale;

public class View {
    private final LocaleManager localeManager;

    public View(Locale locale) {
        this.localeManager = new LocaleManager(locale);
    }

    public void printMainMenu() {
        printMessage(TextConstant.PRINT_INDEX);
        printMessage(TextConstant.PRINT_BY_MIN_AGE);
        printMessage(TextConstant.PRINT_BY_FAMILY);
        printMessage(TextConstant.PRINT_BY_AGE_AND_COLORING);
        printMessage(TextConstant.EXIT);
        printMessage(TextConstant.SAVE);
        printMessage(TextConstant.PRINT_ALL_ANIMALS);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFindByFamilyMenu(String[] families) {
        printMessage(TextConstant.PRINT_INDEX_OF_FAMILY);
        for (int i = 0; i < families.length; i++) {
            printMessage(i + ". " + families[i]);
        }
    }

    public void printAnimals(Animal[] animals) {
        if (animals.length == 0) {
            printMessage(TextConstant.EMPTY);
            return;
        }
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

    public void printFindByColoringMenu(String[] colorings) {
        printMessage(TextConstant.PRINT_INDEX_OF_COLORING);
        for (int i = 0; i < colorings.length; i++) {
            printMessage(i + ". " + colorings[i]);
        }
    }
}
