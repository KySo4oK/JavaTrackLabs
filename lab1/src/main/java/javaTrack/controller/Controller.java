package javaTrack.controller;

import javaTrack.model.Model;
import javaTrack.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private UtilityController utilityController;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        this.utilityController = new UtilityController(this.model, view, scanner);
        utilityController.inputInstruction();
    }
}
