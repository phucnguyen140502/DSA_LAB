package Problem4;

import Problem1_BubbleSortApp.Problem1_BubbleSortApp;
import Problem2_SelectionSortApp.Problem2_SelectionSortApp;
import Problem3_InsertionSortApp.Problem3_InsertionSortApp;

import java.util.Random;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] randomArray1 = new int[n];  // Create an array with n elements
        int[] randomArray2 = new int[n];  // Create an array with n elements
        int[] randomArray3 = new int[n];  // Create an array with n elements

        Random random = new Random();      // Create a Random object for generating random numbers

        // Fill the arrays with random integers
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt();
            randomArray1[i] = randomNumber;// Generate random integer and store it in the array
            randomArray2[i] = randomNumber;
            randomArray3[i] = randomNumber;

        }
        System.out.format("The sort array have %d elements %n",n);
        System.out.println("--------------------------");

        System.out.println("Bubble Sort");
        Problem1_BubbleSortApp.bubbleSort(randomArray1);
        System.out.println("--------------------------");

        System.out.println("Selection Sort");
        Problem2_SelectionSortApp.selectionSort(randomArray2);
        System.out.println("--------------------------");

        System.out.println("Insertion Sort");
        Problem3_InsertionSortApp.insertionSort(randomArray3);
        System.out.println("--------------------------");

    }
}
