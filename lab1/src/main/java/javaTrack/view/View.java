package javaTrack.view;

public class View {
    public void printMainMenu() {
    }

    public void printWrongInputMessage() {
        printMessage(TextConstant.WRONG_INPUT);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
