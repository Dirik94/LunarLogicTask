package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int input, change = 6;

        ArrayList<Integer> numbersArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("To end type any letter...");
            System.out.println("Type numbers:");
            input = sc.nextInt();
            numbersArray.add(input);
        }
        System.out.println("Your numbers are: " + Arrays.toString(numbersArray.toArray()));

        for (int i = 0; i < numbersArray.size(); i++){
            if (numbersArray.get(i) % 9 == 0){
                break;
            }
            if (numbersArray.get(i) % 3 == 2) {
                int x2 = numbersArray.get(i);
                x2 += 1;
                numbersArray.set(numbersArray.indexOf(numbersArray.get(i)),x2);
                change -= 1;
            }
            while (change > 0) {
                if (numbersArray.get(i) % 3 == 1) {
                    int x2 = numbersArray.get(i);
                    x2 += 2;
                    numbersArray.set(numbersArray.indexOf(numbersArray.get(i)), x2);
                    change -= 2;
                }else {
                    break;
                }
            }
        }
        for (int i = 0; i < numbersArray.size(); i++){
            if (change != 0) {
                if (numbersArray.get(i) % 9 != 0) {
                    int x2 = numbersArray.get(i);
                    x2 += change;
                    change = 0;
                    numbersArray.set(numbersArray.indexOf(numbersArray.get(i)), x2);
                }
            }
        }
        System.out.println("Your numbers after task are: " + Arrays.toString(numbersArray.toArray()));
    }
}