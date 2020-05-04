package javaTrack.controller;

import javaTrack.view.View;

import java.util.Scanner;

public class UtilityController {
    private Scanner scanner;
    private View view;

    public UtilityController(View view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }


}
