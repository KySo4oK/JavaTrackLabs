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
        while (true) {
            switch (utilityController.inputLocaleIndex()) {
                case 1:
                    return new Locale("en");
                case 2:
                    return new Locale("ua");
                default:
                    view.printLocalizedMessage(TextConstant.WRONG_INPUT);
                    break;
            }
        }
    }

    private void inputInstruction() {
        while (true) {
            switch (utilityController.inputMenuIndex()) {
                case 1:
                    printAnimalsByMinAge();
                    break;
                case 2:
                    printAnimalsByFamily(model.getFamilies());
                    break;
                case 3:
                    printAnimalsByTypeAndColoring();
                    break;
                case 4:
                    return;
                case 5:
                    saveAnimalsToFile();
                    break;
                case 6:
                    printAllAnimals();
                    break;
                default:
                    view.printLocalizedMessage(TextConstant.WRONG_INPUT);
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
            view.printLocalizedMessage(TextConstant.EMPTY_RESULT);
            view.printLocalizedMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
            return;
        }
        while (true) {
            try {
                model.saveCurrentAnimalsToFile(utilityController.inputFilePath());
            } catch (IOException e) {
                log.error("exception when trying to save in file - {}", e.getMessage());
                view.printLocalizedMessage(TextConstant.ANIMALS_WAS_NOT_SAVED);
                continue;
            }
            view.printLocalizedMessage(TextConstant.ANIMALS_WAS_SAVED);
            return;
        }

    }

    private void printAnimalsByTypeAndColoring() {
        view.printAnimals(model.getAnimalsByTypeAndColoring(utilityController.inputType(model.getTypes()),
                utilityController.inputColoring(model.getColorings())));
    }

    private void printAnimalsByFamily(String[] families) {
        view.printAnimals(model.getAnimalsByFamily(utilityController.inputFamily(families)));
    }

    private void printAnimalsByMinAge() {
        view.printAnimals(model.getAnimalsByMinAge(utilityController.inputMinAge()));
    }

    public void start() {
        view.initLocaleManager(inputLocale());
        inputInstruction();
    }
}
