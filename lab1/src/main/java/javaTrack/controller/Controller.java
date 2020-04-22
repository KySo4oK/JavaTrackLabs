package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;
import javaTrack.view.TextConstant;
import javaTrack.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void inputInstruction() {
        while (true) {
            view.printMainMenu();
            if (scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                switch (scanValue) {
                    case 1:
                        inputMinAgeAndPrintAnimalsByMinAge();
                        break;
                    case 2:
                        inputIndexOfFamilyAndPrintAnimalsByIndexOfFamilies(model.getFamilies());
                        break;
                    case 3:
                        printAnimalsByAgeAndColoring();
                        break;
                    case 4:
                        return;
                }
            } else {
                scanner.nextLine();
            }
            view.printMessage(TextConstant.WRONG_INPUT);
        }
    }

    private void printAnimalsByAgeAndColoring() {
        view.printAnimals(model.getAnimalsByAgeAndColoring(inputAge(),
                inputColoring(model.getColorings())));
    }

    private String inputColoring(String[] colorings) {
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
            view.printMessage(TextConstant.WRONG_INPUT);
        }
    }

    private void isPossibleIndexForColorings(int coloringsLength, int index) {
        if ((index >= coloringsLength) || (index < 0))
            throw new ImpossibleColoringIndexException("index  " + index + " impossible for colorings");
    }

    private int inputAge() {
        while (true) {
            view.printAgeMenu();
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                try {
                    checkAgeForNegative(age);
                } catch (NegativeAgeException e) {
                    view.printMessage(TextConstant.WRONG_INPUT);
                    view.printMessage(e.getMessage());
                    continue;
                }
                return age;
            } else {
                scanner.nextLine();
                view.printMessage(TextConstant.WRONG_INPUT);
            }
        }
    }

    private void inputIndexOfFamilyAndPrintAnimalsByIndexOfFamilies(String[] families) {
        while (true) {
            view.printFindByFamilyMenu(families);
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                try {
                    isPossibleIndexForFamilies(families.length, index);
                } catch (ImpossibleFamilyIndexException e) {
                    view.printMessage(TextConstant.WRONG_INPUT);
                    view.printMessage(e.getMessage());
                    continue;
                }
                printAnimalsByIndexOfFamilies(index);
                return;
            }
            scanner.nextLine();
        }
    }

    private void isPossibleIndexForFamilies(int familiesLength, int index) {
        if ((index >= familiesLength) || (index < 0))
            throw new ImpossibleFamilyIndexException("index  " + index + " impossible for families");
    }

    private void printAnimalsByIndexOfFamilies(int index) {
        view.printAnimals(model.getAnimalsByFamily(model.getFamilies()[index]));
    }

    private void inputMinAgeAndPrintAnimalsByMinAge() {
        while (true) {
            view.printFindByMinAgeMenu();
            if (scanner.hasNextInt()) {
                int minAge = scanner.nextInt();
                try {
                    checkAgeForNegative(minAge);
                } catch (NegativeAgeException e) {
                    view.printMessage(TextConstant.WRONG_INPUT);
                    view.printMessage(e.getMessage());
                    continue;
                }
                printAnimalsByMinAge(minAge);
                return;
            } else {
                scanner.nextLine();
                view.printMessage(TextConstant.WRONG_INPUT);
            }
        }
    }

    private void checkAgeForNegative(int age) {
        if (age < 0) throw new NegativeAgeException("age cannot be less than 0");
    }

    private void printAnimalsByMinAge(int minAge) {
        view.printAnimals(model.getAnimalsByMinAge(minAge));
    }
}
