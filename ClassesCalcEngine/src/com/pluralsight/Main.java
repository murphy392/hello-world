package com.pluralsight;

public class Main {

    public static void main(String[] args) {
	// write your code here
        performCalculations();
    }

    private static void performCalculations() {

        MathEquation[] equations = new MathEquation[4];
        //set the fields
        equations[0] = create(100.0d, 50.0d,'d');
        equations[1] = create(25.0d,92.0d,'a');
        equations[2] = create(225.0,17.0,'s');
        equations[3] = create(11.0d,3.0,'m');


    }

    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.leftVal = leftVal;
        equation.rightVal = rightVal;
        equation.opCode =  opCode;
        return equation;
    }

  
}
