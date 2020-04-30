package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;
import javaTrack.view.TextConstant;
import javaTrack.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) { // replace with no argument constructor
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
                        printAnimalsByAgeAndColoring(); //todo move all input methods to another class
                        break;
                    case 4:
                        return;
                    case 5:
                        saveAnimalsToFile();
                        break;
                    default:
                        view.printMessage(TextConstant.WRONG_INPUT);
                        break;
                }
            } else {
                view.printMessage(TextConstant.WRONG_INPUT);
                scanner.nextLine();
            }
        }
    }

    private void saveAnimalsToFile() {
        if (model.isCurrentAnimalsEmpty()) {
            view.printMessage(TextConstant.EMPTY_RESULT);
            view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
            return;
        }
        while (true) {
            scanner.nextLine();
            view.printMessage(TextConstant.PRINT_FILE_PATH);
            String filePath;
            if (scanner.hasNextLine()) {
                filePath = scanner.nextLine();
                try {
                    model.saveCurrentAnimalsToFile(filePath);
                } catch (IOException e) {
                    view.printMessage(e.getMessage());
                    continue;
                }
                view.printMessage(TextConstant.ANIMALS_WAS_SAVED);
                return;
            }
//            scanner.nextLine();
            view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
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
                    Validator.isPossibleIndexForColorings(colorings.length, index);
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

    private int inputAge() {
        while (true) {
            view.printMessage(TextConstant.PRINT_AGE);
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                try {
                    Validator.checkAgeForNegative(age);
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
                    Validator.isPossibleIndexForColorings(families.length, index);
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

    private void printAnimalsByIndexOfFamilies(int index) {
        view.printAnimals(model.getAnimalsByFamily(model.getFamilies()[index]));
    }

    private void inputMinAgeAndPrintAnimalsByMinAge() {
        while (true) {
            view.printMessage(TextConstant.PRINT_MIN_AGE);
            if (scanner.hasNextInt()) {
                int minAge = scanner.nextInt();
                try {
                    Validator.checkAgeForNegative(minAge);
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

    private void printAnimalsByMinAge(int minAge) {
        view.printAnimals(model.getAnimalsByMinAge(minAge));
    }
}
