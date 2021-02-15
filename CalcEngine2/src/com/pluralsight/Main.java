package com.pluralsight;

public class Main {

    public static void main(String[] args) {
	// write your code here

            double value1 = 100;
            double value2 = 50;
            double result = 0;
            char opCode = 'm';
            //switch(opCode){
            //  case 'a':
                // result = value1 + value2;
                // break;
            // case 's': ---etc...
            if (opCode == 'a'){
                result = value1 + value2;}
            else if (opCode == 's'){
                result = value1 - value2;}
            else if (opCode == 'm'){
                result = value1 * value2;}
            else if (opCode == 'd'){
                if (value2 != 0)
                result = value1 / value2;}
            //default; -- in place of else (SQL Comment for additional comments within comments :) )
            else {

                System.out.println("Invalid Op Code" + opCode);
                result = '0';
            }
            System.out.println(result);
    }
}
