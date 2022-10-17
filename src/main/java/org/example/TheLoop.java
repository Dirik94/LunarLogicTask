package org.example;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TheLoop {

    int changesLeft = 6, max = 0, temp, sum;
    String maxNumber;
    StringBuilder newArray = new StringBuilder();
    LinkedList<Integer> stack = new LinkedList<Integer>();

    private void divideByThree(LinkedList<Integer> numbers) {
        int firstNumber = numbers.get(0);

        int x = sum % 3;
        switch (x) {
            case 1 -> {
                if (firstNumber == 9) {
                    break;
                }
                if (firstNumber != 8) {
                    firstNumber += 2;
                    changesLeft = changesLeft - 2;
                } else {
                    firstNumber += 1;
                    changesLeft = changesLeft - 1;
                }
            }
            case 2 -> {
                if (firstNumber == 9) {
                    break;
                }
                firstNumber += 1;
                changesLeft = changesLeft - 1;
            }
            default -> System.out.println("This number is divisible by 3, skipping");
        }

        numbers.set(numbers.indexOf(numbers.get(0)), firstNumber);
    }

    private void findMaxNumber(int[] numbersArray, int numberOfLoop) {
        temp = numbersArray[numberOfLoop];
        if (temp > max) {
            max = temp;
            maxNumber = String.valueOf(max);
        }
        if (changesLeft >= 3) {
            Pattern p = Pattern.compile("([0-6])");
            Matcher m = p.matcher(maxNumber);
            if (m.find()) {
                int changedNumber = Integer.parseInt(m.group(1));
                changedNumber = changedNumber + 3;
                numbersArray[numberOfLoop] = Integer.parseInt(maxNumber.replaceFirst("[0-6]", String.valueOf(changedNumber)));
                changesLeft = changesLeft - 3;
            }
        }
    }


    public void algorithm(int[] numbersArray) {
        for (int j = 0; j < numbersArray.length; j++) {
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

            while (!numbers.isEmpty()) {
                newArray.append(numbers.pop());
            }
            numbersArray[j] = Integer.parseInt(newArray.toString());
            findMaxNumber(numbersArray, j);

            newArray = new StringBuilder();
        }
    }
}
