package Problem1_SimpleStackApplication;

import java.util.Stack;

public class ConcatenateStack {

    static Stack<Integer> concatenateStacks(Stack<Integer> s1, Stack<Integer> s2){
        Stack<Integer> concatenate = new Stack<>();

        while (!s1.empty()){
            concatenate.push(s1.pop());
        }

        while (!s2.empty()){
            concatenate.push(s2.pop());
        }

        return concatenate;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        Stack<Integer> s2 = new Stack<>();
        s2.push(4);
        s2.push(5);

        Stack<Integer> concatenatedStack = concatenateStacks(s1, s2);
        System.out.println("Concatenated stack: " + concatenatedStack);
    }
}

