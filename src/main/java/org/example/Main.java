package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int input, changesLeft = 6;
        int[] numbersArray = new int[3];
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<Integer>();


        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println("To end type any letter...");
            System.out.println("Type numbers:");
            input = sc.nextInt();
            numbersArray[i] = input;
        }
        System.out.println("Your numbers are: " + Arrays.toString(numbersArray));

        for (int j : numbersArray) {
            LinkedList<Integer> numbers = new LinkedList<Integer>();
            int numbersStack = j;
            int numbersStackTemp = j;
            while (numbersStack > 0) {
                stack.push(numbersStack % 10);
                numbersStack /= 10;
            }

            while (!stack.isEmpty()) {
                numbers.add(stack.pop());
            }
            int sum = 0;
            while (numbersStackTemp != 0) {
                sum += numbersStackTemp % 10;
                numbersStackTemp /= 10;
            }
            System.out.println(sum);

            int firstNumber = numbers.get(0);
            int x = sum % 3;
            switch (x) {
                case 1 -> {
                    firstNumber += 2;
                    changesLeft = changesLeft - 2;
                }
                case 2 -> {
                    firstNumber += 1;
                    changesLeft = changesLeft - 1;
                }
                default -> System.out.println(firstNumber);
            }

            numbers.set(numbers.indexOf(numbers.get(0)), firstNumber);

            System.out.println();
            System.out.println("Your numbers are: " + Arrays.toString(numbers.toArray()));
        }
    }
}