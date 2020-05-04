package javaTrack.controller;

import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;
import javaTrack.view.TextConstant;
import javaTrack.view.View;

import java.util.Scanner;

public class UtilityController {
    private Scanner scanner;
    private View view;

    public UtilityController(View view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    int inputAge() {
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

    String inputColoring(String[] colorings) {
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

    int inputMinAge() {
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
                return minAge;
            } else {
                scanner.nextLine();
                view.printMessage(TextConstant.WRONG_INPUT);
            }
        }
    }

    int inputIndexOfFamily(String[] families) {
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
                return index;
            }
            scanner.nextLine();
        }
    }

    String inputFilePath() {
        while (true) {
            scanner.nextLine();
            view.printMessage(TextConstant.PRINT_FILE_PATH);
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
//            scanner.nextLine();
            view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
        }
    }

}
