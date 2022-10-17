package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var numbersArray = UserInput.getUserInputToArray();

        AlgorithmService loop = new AlgorithmService();
        loop.algorithm(numbersArray);
        loop.addRemainingChanges(numbersArray);
        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}