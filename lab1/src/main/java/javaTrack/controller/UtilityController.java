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

    public void inputInstruction() {
        while (true) {
            view.printMainMenu();
            if (scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                switch (scanValue) {
                    case 1:
                        findByMinAge();
                        break;
                    case 2:
                        findByFamily();
                        break;
                    case 3:
                        findByAgeAndColoring();
                        break;
                    case 4:
                        return;
                    default: {
                        view.printWrongInputMessage();
                        break;
                    }
                }
            } else {
                view.printWrongInputMessage();
                scanner.nextLine();
            }
        }
    }

    private void findByAgeAndColoring() {
    }

    private void findByFamily() {
    }

    private void findByMinAge() {

    }
}
