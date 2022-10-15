package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int input;
        int change = 6;

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
        System.out.println("Your numbers are: " + Arrays.toString(listOfArrays.toArray()));

        for (int i = 0; i < listOfArrays.size(); i++){
            ArrayList<Integer> arr = listOfArrays.get(i);
            for (int x = 0; x < arr.size(); x++){
                if (arr.get(x) % 9 == 0){
                    break;
                }
                if (arr.get(x) % 3 == 2) {
                    int x2 = arr.get(x);
                    x2 += 1;
                    arr.set(arr.indexOf(arr.get(x)),x2);
                    change -= 1;
                }
            }
        }
        for (int i = 0; i < listOfArrays.size(); i++) {
            ArrayList<Integer> arr = listOfArrays.get(i);
            for (int x = 0; x < arr.size(); x++) {
                while (change > 0) {
                    if (arr.get(x) % 3 == 1) {
                        int x2 = arr.get(x);
                        x2 += 2;
                        arr.set(arr.indexOf(arr.get(x)), x2);
                        change -= 2;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println("Your numbers after task are: " + Arrays.toString(listOfArrays.toArray()));
    }
}