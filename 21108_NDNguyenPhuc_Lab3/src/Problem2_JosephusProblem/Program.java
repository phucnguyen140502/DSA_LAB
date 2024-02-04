package Problem2_JosephusProblem;

import Problem1_ApplyLinkedList.DoublyLinkedListApp;
import Problem1_ApplyLinkedList.LinkQueueApp;
import Problem1_ApplyLinkedList.Node;

import java.util.Queue;
import java.util.Scanner;

public class Program {
    static void inputPeopleInCircle(CircleLinkedList<Integer> Queue, int n){
        for (int i = 1; i <= n; i++) {
            Queue.add(i);
        }
    }

    public static void main(String[] args) {
        CircleLinkedList<Integer> Queue = new CircleLinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int n = sc.nextInt();
        inputPeopleInCircle(Queue, n);

        System.out.print("Enter the number used for counting off: ");
        int k = sc.nextInt();
        System.out.print("Enter the number of the person where counting starts: ");
        int startsCounting = sc.nextInt();
        Queue.eliminate(k,startsCounting, n);

        System.out.println();
        System.out.print("Last person standing: ");
        Queue.alive();
    }

}
