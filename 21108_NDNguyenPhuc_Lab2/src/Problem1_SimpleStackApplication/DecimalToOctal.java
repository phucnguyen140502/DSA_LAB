package Problem1_SimpleStackApplication;

import java.util.Stack;

public class DecimalToOctal {

    static void decimalToOctal(int decimalNum){

        Stack<Integer> octal = new Stack<>();
        while (decimalNum > 0){
            octal.push(decimalNum%8);
            decimalNum = decimalNum / 8;
        }
        display(octal);

    }

    private static void display(Stack<Integer> octal){
        while (!octal.empty()){
            System.out.print(octal.pop());
        }
    }

    public static void main(String[] args) {
        decimalToOctal(1465);
    }
}
