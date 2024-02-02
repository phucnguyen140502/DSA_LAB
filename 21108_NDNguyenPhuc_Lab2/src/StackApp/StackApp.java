package StackApp;

import java.util.*;

public class StackApp<T> {

    private int size;

    private Object[] queueArray;

    public StackApp(int capacity) {
        size = 0;
        queueArray = new Object[capacity];

    }

    public void push(T element) {
        for (int i = 0; i < queueArray.length; i++) {
            if (queueArray[i] == null) {
                queueArray[i] = element;
                size++;
                break;
            }
        }
    }

    private T elementData(int index) {
        return (T) queueArray[index];
    }

    public synchronized T peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        return elementData(len - 1);

    }

    public T pop() {
        T obj = peek();

        queueArray[size - 1] = null;
        size--;
        return obj;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == queueArray.length;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The Capacity of Stack: ");
        int capacityOfStack = sc.nextInt();
        StackApp<Integer> stack = new StackApp<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.size());

        System.out.println(stack.pop());

        System.out.println(stack.peek());



    }

}
