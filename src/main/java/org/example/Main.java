package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int input;

        ArrayList<ArrayList<Integer>> listOfArrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type number of Arrays");
        int numberOfArrays = sc.nextInt();
        for (int i = 0; i < numberOfArrays; i++) {
            ArrayList<Integer> numbersArray = new ArrayList<>();
            System.out.println("To end type any letter...");
            System.out.println("Type numbers:");
            while (sc.hasNextInt()) {
                input = sc.nextInt();
                numbersArray.add(input);
            }
            listOfArrays.add(numbersArray);
            sc.next();
        }
        System.out.println(Arrays.toString(listOfArrays.toArray()));
    }
}