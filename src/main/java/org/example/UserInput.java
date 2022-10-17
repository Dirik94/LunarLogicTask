package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class UserInput {
    int input = 0;
    int[] numbersArray = new int[3];
    Scanner sc = new Scanner(System.in);

    public UserInput() {
    }

    public int[] getUserInputToArray() {
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println("To end, type any letter...");
            System.out.println("Type numbers:");
            try {
                input = sc.nextInt();
                numbersArray[i] = input;
            } catch (InputMismatchException e) {
                System.out.println("You are allowed to add only numbers. To end type new line with any letter.");
                i--;
                sc.next();
            }
        }
        System.out.println("Your numbers are: " + Arrays.toString(numbersArray));
        return numbersArray;
    }
}
