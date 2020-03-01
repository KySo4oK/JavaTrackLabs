package javaTrack;

import javaTrack.controller.Controller;
import javaTrack.model.Model;
import javaTrack.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
