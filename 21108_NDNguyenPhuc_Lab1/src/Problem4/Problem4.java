package Problem4;


import Problem1_BubbleSortApp.ArrayBub;
import Problem2_SelectionSortApp.ArraySel;
import Problem3_InsertionSortApp.ArrayIns;

import java.util.Random;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random num = new Random();

        ArrayBub bub = new ArrayBub(n);
        ArraySel sel = new ArraySel(n);
        ArrayIns ins = new ArrayIns(n);

        for (int i = 0; i < n; i++) {
            bub.insert(num.nextLong());
            sel.insert(num.nextLong());
            ins.insert(num.nextLong());
        }


        System.out.format("The sort array have %d elements %n",n);
        System.out.println("--------------------------");
        bub.display();
        sel.display();
        ins.display();
        System.out.println("Bubble Sort");
        bub.bubbleSort();
        bub.display();
        System.out.println("--------------------------");

        System.out.println("Selection Sort");
        sel.selectionSort();
        sel.display();
        System.out.println("--------------------------");

        System.out.println("Insertion Sort");
        ins.insertionSort();
        ins.display();
        System.out.println("--------------------------");

    }
}
