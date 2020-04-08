package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;
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
                try {
                    isPossibleIndexForColorings(colorings.length, index);
                } catch (ImpossibleColoringIndexException e) {
                    view.printMessage(e.getMessage());
                    continue;
                }
                return colorings[index];
            }
            scanner.nextLine();
            view.printWrongInputMessage();
        }
    }

    private void isPossibleIndexForColorings(int coloringsLength, int index) {
        if ((index >= coloringsLength) || (index < 0))
            throw new ImpossibleColoringIndexException("index  " + index + " impossible for colorings");
    }

    private int findAge() {
        while (true) {
            view.printAgeMenu();
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                try {
                    checkAgeForNegative(age);
                } catch (NegativeAgeException e) {
                    view.printWrongInputMessage();
                    view.printMessage(e.getMessage());
                    continue;
                }
                return age;
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
                try {
                    isPossibleIndexForFamilies(families.length, index);
                } catch (ImpossibleFamilyIndexException e) {
                    view.printWrongInputMessage();
                    view.printMessage(e.getMessage());
                    continue;
                }
                setFamilyAndPrint(index);
                return;
            }
            scanner.nextLine();
        }
    }

    private void isPossibleIndexForFamilies(int familiesLength, int index) {
        if ((index >= familiesLength) || (index < 0))
            throw new ImpossibleFamilyIndexException("index  " + index + " impossible for families");
    }

    private void setFamilyAndPrint(int index) {
        view.printAnimals(model.getAnimalsByFamily(model.getFamilies()[index]));
    }

    private void findByMinAge() {
        while (true) {
            view.printFindByMinAgeMenu();
            if (scanner.hasNextInt()) {
                int minAge = scanner.nextInt();
                try {
                    checkAgeForNegative(minAge);
                } catch (NegativeAgeException e) {
                    view.printWrongInputMessage();
                    view.printMessage(e.getMessage());
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

    private void checkAgeForNegative(int age) {
        if (age < 0) throw new NegativeAgeException("age cannot be less than 0");
    }

    private void setMinAgeAndPrint(int minAge) {
        view.printAnimals(model.getAnimalsByMinAge(minAge));
    }
}
