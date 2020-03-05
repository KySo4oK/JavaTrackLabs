package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.view.View;

import java.util.Scanner;

class UtilityController {
    private Model model;
    private View view;
    private Scanner scanner;

    UtilityController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
    }

    void inputInstruction() {
        while (true) {
            view.printMainMenu();
            if (scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                switch (scanValue) {
                    case 1:
                        findByMinAge();
                        break;
                    case 2:
                        findByFamily(model.getFamilies());
                        break;
                    case 3:
                        findByAgeAndColoring();
                        break;
                    case 4:
                        return;
                    default:
                        view.printWrongInputMessage();
                        break;
                }
            } else {
                view.printWrongInputMessage();
                scanner.nextLine();
            }
        }
    }

    private void findByAgeAndColoring() {
        view.printAnimals(model.getAnimalsByAgeAndColoring(findAge(),
                findColoring(model.getColorings())));
    }

    private String findColoring(String[] colorings) {
        while (true) {
            view.printFindByColoringMenu(colorings);
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if ((index < colorings.length) && (index >= 0)) {
                    return colorings[index];
                }
            }
            scanner.nextLine();
            view.printWrongInputMessage();
        }
    }

    private int findAge() {
        while (true) {
            view.printAgeMenu();
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age >= 0) {
                    return age;
                }
                view.printWrongInputMessage();
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private void findByFamily(String[] families) {
        while (true) {
            view.printFindByFamilyMenu(families);
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if ((index < families.length) && (index >= 0)) {
                    setFamilyAndPrint(index);
                    return;
                }
            }
            scanner.nextLine();
            view.printWrongInputMessage();
        }
    }

    private void setFamilyAndPrint(int index) {
        view.printAnimals(model.getAnimalsByFamily(model.getFamilies()[index]));
    }

    private void findByMinAge() {
        while (true) {
            view.printFindByMinAgeMenu();
            if (scanner.hasNextInt()) {
                int minAge = scanner.nextInt();
                if (minAge < 0) {
                    view.printWrongInputMessage();
                    continue;
                }
                setMinAgeAndPrint(minAge);
                return;
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private void setMinAgeAndPrint(int minAge) {
        view.printAnimals(model.getAnimalsByMinAge(minAge));
    }
}
