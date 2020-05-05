package JavaTrackLabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Integer> list = generateArrayList(15);
        System.out.println("List - " + list);
        int value = inputValue();
        System.out.println("Nearest - " + getNearestToValue(list, value));
    }

    private static int getNearestToValue(List<Integer> list, int value) {
        int smallestDifference = Math.abs(list.get(0) - value);
        int nearestIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            int currentDifference = Math.abs(list.get(i) - value);
            if (smallestDifference > currentDifference) {
                smallestDifference = currentDifference;
                nearestIndex = i;
            }
        }
        return list.get(nearestIndex);
    }

    private static int inputValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Print value");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
    }

    private static List<Integer> generateArrayList(int number) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }
}
