package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        UserInput input = new UserInput();
        int[] numbersArray = input.getUserInputToArray();

        TheLoop loop = new TheLoop();
        loop.algorithm(numbersArray);

        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}