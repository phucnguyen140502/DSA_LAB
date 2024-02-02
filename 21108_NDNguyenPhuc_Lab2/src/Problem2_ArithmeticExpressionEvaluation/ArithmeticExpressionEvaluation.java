package Problem2_ArithmeticExpressionEvaluation;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpressionEvaluation {
    private static boolean In(String a, String[] b) {
        for (int i = 0; i < b.length; i++) {
            if (Objects.equals(b[i], a)) {
                return true;
            }
        }
        return false;
    }

    public static String infixToPostfix(String infix){
        String[] operator = new String[]{"+", "-", "*", "/", "^"};
        Stack<String> stack = new Stack<>();
        String RPN = "";
        for (int j = 0; j < infix.length(); j++) {
            if (48 <= (int) infix.charAt(j) && (int) infix.charAt(j) <= 57) {
                RPN += infix.charAt(j);
            } else if (In(String.valueOf(infix.charAt(j)), operator)) {
                stack.push(String.valueOf(infix.charAt(j)));
            } else if (String.valueOf(infix.charAt(j)).equals(")")) {
                RPN += stack.peek();
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            RPN += stack.pop();
        }
        return RPN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String infix = sc.next();

        System.out.println(infixToPostfix(infix));
    }

}
