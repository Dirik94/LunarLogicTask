package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        int input, changesLeft = 6, max = 0, temp;
        String newArray = "";
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

        for (int j = 0 ; j < numbersArray.length; j++) {
            LinkedList<Integer> numbers = new LinkedList<Integer>();
            int numbersStack = numbersArray[j];
            int numbersStackTemp = numbersArray[j];
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

            int firstNumber = numbers.get(0);

            int x = sum % 3;
            switch (x) {
                case 1 -> {
                    if (firstNumber != 8){
                        firstNumber += 2;
                        changesLeft = changesLeft - 2;
                    }else {
                        firstNumber += 1;
                        changesLeft = changesLeft - 1;
                    }
                }
                case 2 -> {
                    firstNumber += 1;
                    changesLeft = changesLeft - 1;
                }
                default -> System.out.println("This number is divisible by 3, skipping");
            }

                numbers.set(numbers.indexOf(numbers.get(0)), firstNumber);

//            System.out.println();
//            System.out.println("Your numbers are: " + Arrays.toString(numbers.toArray()));

            while (!numbers.isEmpty()){
                newArray = newArray + numbers.pop();
            }
            numbersArray[j] = Integer.parseInt(newArray);
            temp = numbersArray[j];
            if (temp < max){
                max = temp;
                String maxNumber = String.valueOf(max);
                if (changesLeft >= 3){
                    Pattern p = Pattern.compile("([0-6])");
                    Matcher m = p.matcher(maxNumber);
                    if (m.find()) {
                        int changedNumber = Integer.parseInt(m.group(1));
                        changedNumber = changedNumber + 3;
                        numbersArray[j] = Integer.parseInt(maxNumber.replaceFirst("[0-6]",String.valueOf(changedNumber)));
                        changesLeft = changesLeft - 3;
                    }
                }
            }
            newArray = "";
        }
        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}