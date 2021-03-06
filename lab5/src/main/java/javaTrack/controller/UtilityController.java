package javaTrack.controller;

import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;
import javaTrack.view.TextConstant;
import javaTrack.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

class UtilityController {
    private Scanner scanner;
    private View view;
    private static final Logger log = LogManager.getLogger(UtilityController.class);

    UtilityController(View view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    int inputMenuIndex() {
        while (true) {
            view.printMainMenu();
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                view.printLocalizedMessage(TextConstant.WRONG_INPUT);
                scanner.nextLine();
            }
        }
    }

    int inputAge() {
        while (true) {
            view.printLocalizedMessage(TextConstant.PRINT_AGE);
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                try {
                    Validator.checkAgeForNegative(age);
                } catch (NegativeAgeException e) {
                    log.error("exception in checking age - {}", e.getMessage());
                    view.printLocalizedMessage(TextConstant.WRONG_INPUT);
                    view.printMessage(e.getMessage());
                    continue;
                }
                return age;
            } else {
                scanner.nextLine();
                view.printLocalizedMessage(TextConstant.WRONG_INPUT);
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
                    log.error("exception in checking index for coloring - {}", e.getMessage());
                    view.printMessage(e.getMessage());
                    continue;
                }
                return colorings[index];
            }
            scanner.nextLine();
            view.printLocalizedMessage(TextConstant.WRONG_INPUT);
        }
    }

    int inputMinAge() {
        while (true) {
            view.printLocalizedMessage(TextConstant.PRINT_MIN_AGE);
            if (scanner.hasNextInt()) {
                int minAge = scanner.nextInt();
                try {
                    Validator.checkAgeForNegative(minAge);
                } catch (NegativeAgeException e) {
                    log.error("exception in checking age - {}", e.getMessage());
                    view.printLocalizedMessage(TextConstant.WRONG_INPUT);
                    view.printMessage(e.getMessage());
                    continue;
                }
                return minAge;
            } else {
                scanner.nextLine();
                view.printLocalizedMessage(TextConstant.WRONG_INPUT);
            }
        }
    }

    int inputIndexOfFamily(String[] families) {
        while (true) {
            view.printFindByFamilyMenu(families);
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                try {
                    Validator.isPossibleIndexForFamilies(families.length, index);
                } catch (ImpossibleFamilyIndexException e) {
                    log.error("exception in checking index for family - {}", e.getMessage());
                    view.printLocalizedMessage(TextConstant.WRONG_INPUT);
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
            view.printLocalizedMessage(TextConstant.PRINT_FILE_PATH);
            if (scanner.hasNext()) {
                return scanner.next();
            }
            view.printLocalizedMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
        }
    }

    int inputLocaleIndex() {
        while (true) {
            view.printLanguageMenu();
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                view.printLocalizedMessage(TextConstant.WRONG_INPUT);
                scanner.nextLine();
            }
        }
    }
}
