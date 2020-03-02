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
                        findByFamily();
                        break;
                    case 3:
                        findByAgeAndColoring();
                        break;
                    case 4:
                        return;
                    default:
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
                findColoring()));
    }

    private String findColoring() {
        while (true) {
            view.printFindByColoringMenu();
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if (index < view.colorings.length) {
                    return view.colorings[index];
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
                return scanner.nextInt();
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private void findByFamily() {
        while (true) {
            view.printFindByFamilyMenu();
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if (index < view.families.length) {
                    setFamilyAndPrint(index);
                    return;
                }
            }
            scanner.nextLine();
            view.printWrongInputMessage();
        }
    }

    private void setFamilyAndPrint(int index) {
        view.printAnimals(model.getAnimalsByFamily(view.families[index]));
    }

    private void findByMinAge() {
        while (true) {
            view.printFindByMinAgeMenu();
            if (scanner.hasNextInt()) {
                setMinAgeAndPrint();
                return;
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private void setMinAgeAndPrint() {
        view.printAnimals(model.getAnimalsByMinAge(scanner.nextInt()));
    }
}
