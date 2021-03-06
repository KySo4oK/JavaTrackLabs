package javaTrack.view;

import javaTrack.model.Animal;

import java.util.Arrays;
import java.util.Locale;

public class View {
    private LocaleManager localeManager;

    public View() {
    }

    public void printMainMenu() {
        printLocalizedMessage(TextConstant.PRINT_INDEX);
        printLocalizedMessage(TextConstant.PRINT_BY_MIN_AGE);
        printLocalizedMessage(TextConstant.PRINT_BY_FAMILY);
        printLocalizedMessage(TextConstant.PRINT_BY_TYPE_AND_COLORING);
        printLocalizedMessage(TextConstant.EXIT);
        printLocalizedMessage(TextConstant.SAVE);
        printLocalizedMessage(TextConstant.PRINT_ALL_ANIMALS);
    }

    public void printLocalizedMessage(String message) {
        printMessage(localeManager.getString(message));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFindByFamilyMenu(String[] families) {
        printLocalizedMessage(TextConstant.PRINT_FAMILY);
        Arrays.stream(families).forEach(this::printMessage);
    }

    public void printAnimals(Animal[] animals) {
        if (animals.length == 0) {
            printLocalizedMessage(TextConstant.EMPTY);
            return;
        }
        Arrays.stream(animals).map(animal -> "type='" + animal.getType() + '\'' +
                ", family='" + animal.getFamily() + '\'' +
                ", lineage='" + animal.getLineage() + '\'' +
                ", kind='" + animal.getKind() + '\'' +
                ", subspecies='" + animal.getSubspecies() + '\'' +
                ", coloring='" + animal.getColoring() + '\'' +
                ", age=" + animal.getAge()).forEach(this::printMessage);
    }

    public void printFindByColoringMenu(String[] colorings) {
        printLocalizedMessage(TextConstant.PRINT_COLORING);
        Arrays.stream(colorings).forEach(this::printMessage);
    }

    public void initLocaleManager(Locale locale) {
        this.localeManager = new LocaleManager(locale);
    }

    public void printLanguageMenu() {
        printMessage(TextConstant.PRINT_INDEX_OF_LANGUAGE);
        printMessage(TextConstant.ENGLISH_LANGUAGE);
        printMessage(TextConstant.UKRAINIAN_LANGUAGE);
    }

    public void printFindByTypeMenu(String[] types) {
        printLocalizedMessage(TextConstant.PRINT_TYPE);
        Arrays.stream(types).forEach(System.out::println);
    }
}
