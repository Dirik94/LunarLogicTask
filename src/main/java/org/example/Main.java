package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Integer[] numbersArray = UserInput.getUserInputToArray();
        Arrays.sort(numbersArray, Collections.reverseOrder());

        AlgorithmService loop = new AlgorithmService();
        loop.algorithm(numbersArray);
        loop.addRemainingChanges(numbersArray);
        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}