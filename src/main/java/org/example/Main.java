package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UserInput{
    int input = 0;
    int[] numbersArray = new int[3];
    Scanner sc = new Scanner(System.in);

    public UserInput(){}

    public int[] getUserInputToArray(){
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println("To end, type any letter...");
            System.out.println("Type numbers:");
            try{
                input = sc.nextInt();
                numbersArray[i] = input;
            }catch(InputMismatchException e){
                System.out.println("You are allowed to add only numbers. To end type new line with any letter.");
                i--;
                sc.next();
            }
        }
        System.out.println("Your numbers are: " + Arrays.toString(numbersArray));
        return numbersArray;
    }
}

class TheLoop{

    int changesLeft = 6, max = 0, temp, sum;
    StringBuilder newArray = new StringBuilder();
    LinkedList<Integer> stack = new LinkedList<Integer>();

    private void divideByThree(LinkedList<Integer> numbers){
        int firstNumber = numbers.get(0);

        int x = sum % 3;
        switch (x) {
            case 1 -> {
                if (firstNumber == 9){
                    break;
                }
                if (firstNumber != 8){
                    firstNumber += 2;
                    changesLeft = changesLeft - 2;
                }else {
                    firstNumber += 1;
                    changesLeft = changesLeft - 1;
                }
            }
            case 2 -> {
                if (firstNumber == 9){
                    break;
                }
                firstNumber += 1;
                changesLeft = changesLeft - 1;
            }
            default -> System.out.println("This number is divisible by 3, skipping");
        }

        numbers.set(numbers.indexOf(numbers.get(0)), firstNumber);
    }

    private void findMaxNumber(int[] numbersArray, int numberOfLoop){
        temp = numbersArray[numberOfLoop];
        if (temp < max){
            max = temp;
            String maxNumber = String.valueOf(max);
            if (changesLeft >= 3){
                Pattern p = Pattern.compile("([0-6])");
                Matcher m = p.matcher(maxNumber);
                if (m.find()) {
                    int changedNumber = Integer.parseInt(m.group(1));
                    changedNumber = changedNumber + 3;
                    numbersArray[numberOfLoop] = Integer.parseInt(maxNumber.replaceFirst("[0-6]",String.valueOf(changedNumber)));
                    changesLeft = changesLeft - 3;
                }
            }
        }
    }



    public void algorithm(int[] numbersArray){
        for (int j = 0 ; j < numbersArray.length; j++) {
            LinkedList<Integer> numbers = new LinkedList<Integer>();
            int numbersStackTemp = numbersArray[j];

            sum = 0;
            while (numbersStackTemp != 0) {
                int num = numbersStackTemp % 10;
                stack.push(num);
                sum += num;
                numbersStackTemp /= 10;
            }

            while (!stack.isEmpty()) {
                numbers.add(stack.pop());
            }

            divideByThree(numbers);

            while (!numbers.isEmpty()){
                newArray.append(numbers.pop());
            }
            numbersArray[j] = Integer.parseInt(newArray.toString());
            findMaxNumber(numbersArray, j);

            newArray = new StringBuilder();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        UserInput input = new UserInput();
        int[] numbersArray = input.getUserInputToArray();

        TheLoop loop = new TheLoop();
        loop.algorithm(numbersArray);

        System.out.println("Your new numbers are: " + Arrays.toString(numbersArray));
    }
}