package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.view.TextConstant;
import javaTrack.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Locale;

public class Controller {
    private Model model;
    private View view;
    private UtilityController utilityController;
    private static final Logger log = LogManager.getLogger(Controller.class);

    public Controller() {
        this.view = new View();
        try {
            this.model = new Model();
        } catch (IOException e) {
            log.fatal("cannot run app - {}", e.getMessage());
            view.printMessage(TextConstant.FATAL_ERROR);
            System.exit(-1);
        }
        this.utilityController = new UtilityController(view);
    }

    private Locale inputLocale() {
        if (utilityController.inputLocaleIndex() == 1) {
            return new Locale("en");
        }
        return new Locale("ua");
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
                case 6:
                    printAllAnimals();
                default:
                    view.printMessage(TextConstant.WRONG_INPUT);
                    break;
            }
        }
    }

    private void printAllAnimals() {
        view.printAnimals(model.getAnimals());
    }

    private void saveAnimalsToFile() {
        if (model.isCurrentAnimalsEmpty()) {
            log.warn("trying to save empty result");
            view.printMessage(TextConstant.EMPTY_RESULT);
            view.printMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
            return;
        }
        while (true) {
            try {
                model.saveCurrentAnimalsToFile(utilityController.inputFilePath());
            } catch (IOException e) {
                log.error("exception when trying to save in file - {}", e.getMessage());
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

    public void start() {
        view.initLocaleManager(inputLocale());
        inputInstruction();
    }
}
