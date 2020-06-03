package javaTrack.view;

import javaTrack.model.Animal;

import java.util.Locale;

public class View {
    private LocaleManager localeManager;

    public View() {
    }

    public void printMainMenu() {
        printLocalizedMessage(TextConstant.PRINT_INDEX);
        printLocalizedMessage(TextConstant.PRINT_BY_MIN_AGE);
        printLocalizedMessage(TextConstant.PRINT_BY_FAMILY);
        printLocalizedMessage(TextConstant.PRINT_BY_AGE_AND_COLORING);
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
        printLocalizedMessage(TextConstant.PRINT_INDEX_OF_FAMILY);
        for (int i = 0; i < families.length; i++) {
            printMessage(i + ". " + families[i]);
        }
    }

    public void printAnimals(Animal[] animals) {
        if (animals.length == 0) {
            printLocalizedMessage(TextConstant.EMPTY);
            return;
        }
        for (Animal animal : animals) {
            printMessage("type='" + animal.getType() + '\'' +
                    ", family='" + animal.getFamily() + '\'' +
                    ", lineage='" + animal.getLineage() + '\'' +
                    ", kind='" + animal.getKind() + '\'' +
                    ", subspecies='" + animal.getSubspecies() + '\'' +
                    ", coloring='" + animal.getColoring() + '\'' +
                    ", age=" + animal.getAge());
        }
    }

    public void printFindByColoringMenu(String[] colorings) {
        printLocalizedMessage(TextConstant.PRINT_INDEX_OF_COLORING);
        for (int i = 0; i < colorings.length; i++) {
            printMessage(i + ". " + colorings[i]);
        }
    }

    public void initLocaleManager(Locale locale) {
        this.localeManager = new LocaleManager(locale);
    }

    public void printLanguageMenu() {
        printMessage(TextConstant.PRINT_INDEX_OF_LANGUAGE);
        printMessage(TextConstant.ENGLISH_LANGUAGE);
        printMessage(TextConstant.UKRAINIAN_LANGUAGE);
    }
}
