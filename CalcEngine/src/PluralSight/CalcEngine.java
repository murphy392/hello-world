package src.PluralSight;

public class CalcEngine {

    public static void main(String[] args) {
        double value1 = 100;
        double value2 = 50;
        double result = 0;
        char opCode = 'a';

        if (opCode == 'a')
            result = value1 + value2;
        else if (opCode == 's')
            result = value1 - value2;
        else if (opCode == 'd')
            result = value1 / value2;
        else if (opCode == 'm')
            result = value1 * value2;
        else result = '0';

        system.out.println(result);
    }

}

