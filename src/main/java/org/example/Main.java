package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(998%3);
        var numbersArray = UserInput.getUserInputToArray();

        AlgorithmService loop = new AlgorithmService();
        loop.algorithm(numbersArray);
        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}