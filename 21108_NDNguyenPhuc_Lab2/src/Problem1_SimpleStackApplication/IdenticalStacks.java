package Problem1_SimpleStackApplication;

import java.util.Stack;

public class IdenticalStacks {

    public static boolean areIdentical(Stack<Integer> s1, Stack<Integer> s2){
        if (s1.size() != s2.size()) {
            return false;
        }
        Stack<Integer> temp = new Stack<>();
        while (!s1.isEmpty()){
            int top1 = s1.pop();
            int top2 = s2.pop();
            if (top2 != top1) {
                return false;
            }
            temp.push(top1);
            temp.push(top2);
        }


        // Recovery
        while (!temp.isEmpty()) {
            s2.push(temp.pop());
            s1.push(temp.pop());
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        Stack<Integer> s2 = new Stack<>();
        s2.push(3);
        s2.push(2);
        s2.push(1);

        boolean identical = areIdentical(s1, s2);

        System.out.println(identical);
    }
}


