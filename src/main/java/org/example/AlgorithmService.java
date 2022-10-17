package org.example;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AlgorithmService {

    private int changesLeft = 6, max = 0, sum;
    private String maxNumber;
    private StringBuilder newArray = new StringBuilder();
    private LinkedList<Integer> stack = new LinkedList<Integer>();

    private void divideByThree(LinkedList<Integer> numbers) {
        int firstNumber = numbers.get(0);


        int x = sum % 3;
        switch (x) {
            case 1 -> {
                if (firstNumber == 9) break;
                if (changesLeft < 2) break;
                if (firstNumber != 8) {
                    firstNumber += 2;
                    changesLeft = changesLeft - 2;
                } else {
                    firstNumber += 1;
                    changesLeft = changesLeft - 1;
                }
            }
            case 2 -> {
                if (firstNumber == 9) break;
                if (changesLeft == 0) break;
                firstNumber += 1;
                changesLeft = changesLeft - 1;
            }
            default -> System.out.println();
        }

        numbers.set(numbers.indexOf(numbers.get(0)), firstNumber);
    }
    private void findMaxNumber(int[] numbersArray, int numberOfLoop) {
        int temp = numbersArray[numberOfLoop];
        if (temp > max) {
            max = temp;
            maxNumber = String.valueOf(max);
            if (changesLeft >= 3) {
                Pattern p = Pattern.compile("([0-6])");
                Matcher m = p.matcher(maxNumber);
                increaseNumberByThree(numbersArray, numberOfLoop, m);
            }
        }
    }

    private void increaseNumberByThree(int[] numbersArray, int numberOfLoop, Matcher m) {
        if (m.find()) {
            int changedNumber = Integer.parseInt(m.group(1));
            changedNumber = changedNumber + 3;
            numbersArray[numberOfLoop] = Integer.parseInt(maxNumber.replaceFirst("[0-6]", String.valueOf(changedNumber)));
            changesLeft = changesLeft - 3;
        }
    }

    private void addRemainingChanges(int[] numbersArray) {
//        if (changesLeft > 0) {
//            for (int i = 0; i < numbersArray.length; i++) {
//                while (changesLeft > 0) {
//                    if (numbersArray[i] % 9 > 0 && numbersArray[i] % 3 == 0) {
//                        numbersArray[i] += 3;
//                        changesLeft -= 3;
//                    }else {
//                        break;
//
//                    }
//                }
//            }
//        }
//        if (changesLeft > 0) {
//            for (int i = 0; i < numbersArray.length; i++) {
//                while (changesLeft > 0) {
//                    if (numbersArray[i] % 3 > 0) {
//                        numbersArray[i] += 1;
//                        changesLeft -= 1;
//                    }else {
//                        break;
//                    }
//                }
//            }
//        }
    }


    public void algorithm(int[] numbersArray) {
        for (int j = 0; j < numbersArray.length; j++) {
            LinkedList<Integer> numbers = new LinkedList<Integer>();
            int numbersStackTemp = numbersArray[j];

            if (numbersStackTemp <= 0){
                break;
            }

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

            while (!numbers.isEmpty()) {
                newArray.append(numbers.pop());
            }
            numbersArray[j] = Integer.parseInt(newArray.toString());
            if (numbersArray[j] == numbersArray[numbersArray.length - 1]){
                findMaxNumber(numbersArray, j);
            }

            newArray = new StringBuilder();
        }
        addRemainingChanges(numbersArray);
    }
}
