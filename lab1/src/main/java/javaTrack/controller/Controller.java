package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.view.TextConstant;
import javaTrack.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;
    private UtilityController utilityController;

    public Controller() {
        this.view = new View();
        try {
            this.model = new Model();
        } catch (IOException e) {
            view.printMessage(TextConstant.FATAL_ERROR);
            view.printMessage(e.getMessage());
            System.exit(0);
        }
        this.utilityController = new UtilityController(view);
        this.scanner = new Scanner(System.in);
    }

    public void inputInstruction() {
        while (true) {
            switch (utilityController.inputMenuIndex()) {
                case 1:
                    printAnimalsByMinAge();
                    break;
                case 2:
                    printAnimalsByIndexOfFamilies(model.getFamilies());
                    break;
                case 3:
                    printAnimalsByAgeAndColoring();
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
        }
    }

    private void saveAnimalsToFile() {
        if (model.isCurrentAnimalsEmpty()) {
            view.printMessage(TextConstant.EMPTY_RESULT);
            view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
            return;
        }
        while (true) {
            try {
                model.saveCurrentAnimalsToFile(utilityController.inputFilePath());
            } catch (IOException e) {
                view.printMessage(e.getMessage());
                view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
                continue;
            }
            view.printMessage(TextConstant.ANIMALS_WAS_SAVED);
            return;
        }

    }

    private void printAnimalsByAgeAndColoring() {
        view.printAnimals(model.getAnimalsByAgeAndColoring(utilityController.inputAge(),
                utilityController.inputColoring(model.getColorings())));
    }

    private void printAnimalsByIndexOfFamilies(String[] families) {
        printAnimalsByIndexOfFamilies(utilityController.inputIndexOfFamily(families));
    }

    private void printAnimalsByIndexOfFamilies(int index) {
        view.printAnimals(model.getAnimalsByFamily(model.getFamilies()[index]));
    }

    private void printAnimalsByMinAge() {
        view.printAnimals(model.getAnimalsByMinAge(utilityController.inputMinAge()));
    }
}
