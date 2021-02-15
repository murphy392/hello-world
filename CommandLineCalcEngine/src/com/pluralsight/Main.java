package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for (double printResults : results) {
                System.out.println(printResults);
            }
        } else if(args.length == 1 && args[0].equals("interactive")){
            executeInteractively();
        }
        else if(args.length ==3){
            handleCommandLine(args);
        }else
            System.out.println("Please provide and opCode and 2 numerical values");
    }
    //take input from the user
    static void executeInteractively(){
        System.out.println("Enter an operation and two number:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split( " ");
        performOperation(parts);
    }

    //do operation by calling the other methods.
    //getters and setters
    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        if (opCode == 'w') {
            handleWhen(parts);
        } else {
            double leftVal = valueFromWord(parts[1]);
            double rightVale = valueFromWord(parts[2]);
            double result = execute(opCode, leftVal, rightVale);
            //System.out.println(result);
            displayResult(opCode, leftVal, rightVale, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s",startDate,daysToAdd,newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal, double rightVale, double result) {
        char symbol = symbolFromOpCode(opCode);
        /* below code is for the string builder class
        StringBuilder builder = new StringBuilder( 20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVale);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        */
        String output = String.format("%.3f %c %.3f = %.3f", leftVal,opCode,rightVale,result);
        System.out.println(output);
    }

    //get symbol from opCode
    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a','s','m','d'};
        char[] symbols = {'+','-','*','/'};
        char symbol = ' ';
        //loop through the opCodes array to find out what opCode was passed in and return the symbol
        for (int index = 0; index < opCodes.length; index++){
            if (opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    //handle data input while calling the program
    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode,leftVal,rightVal);
        System.out.println(result);
    }
    // do the math
    static double execute(char opCode,double leftVal,double rightVal){
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }
    //method to get the opCode
    static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    //Value from Word
    static double valueFromWord(String word){
        String[] numberWords = {
                "zero","one","two",
                "three", "four", "five",
                "six", "seven", "eight", "nine"
        };
        //establish method variable
        double value = -1d;
        for (int index=0; index < numberWords.length; index++){
            //check the array for what was typed in
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        if (value == -1d){
           value = Double.parseDouble(word);
        }



        return value;
    }
}
