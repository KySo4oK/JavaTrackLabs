package javaTrack.controller;

import javaTrack.model.exception.ImpossibleColoringIndexException;
import javaTrack.model.exception.ImpossibleFamilyIndexException;
import javaTrack.model.exception.NegativeAgeException;

class Validator {
    static void isPossibleIndexForColorings(int coloringsLength, int index) {
        if ((index >= coloringsLength) || (index < 0))
            throw new ImpossibleColoringIndexException("index  " + index + " impossible for colorings");
    }

    static void isPossibleIndexForFamilies(int familiesLength, int index) {
        if ((index >= familiesLength) || (index < 0))
            throw new ImpossibleFamilyIndexException("index  " + index + " impossible for families");
    }

    static void checkAgeForNegative(int age) {
        if (age < 0) throw new NegativeAgeException("age - " + age + " impossible");
    }
}
