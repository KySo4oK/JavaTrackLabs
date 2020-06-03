package javaTrack.controller;

import javaTrack.model.exception.ImpossibleColoringException;
import javaTrack.model.exception.ImpossibleFamilyException;
import javaTrack.model.exception.ImpossibleTypeException;
import javaTrack.model.exception.NegativeAgeException;

import java.util.Arrays;

class Validator {
    static void checkAgeForNegative(int age) {
        if (age < 0) throw new NegativeAgeException("age - " + age + " impossible");
    }

    static void isPossibleType(String[] types, String type) {
        if (Arrays.stream(types).noneMatch(type::equals)) {
            throw new ImpossibleTypeException("type " + type + " not exist");
        }
    }

    static void isPossibleFamily(String[] families, String family) {
        if (Arrays.stream(families).noneMatch(family::equals)) {
            throw new ImpossibleFamilyException("family " + family + " not exist");
        }
    }

    static void isPossibleColoring(String[] colorings, String coloring) {
        if (Arrays.stream(colorings).noneMatch(coloring::equals)) {
            throw new ImpossibleColoringException("coloring " + coloring + " not exist");
        }
    }
}
