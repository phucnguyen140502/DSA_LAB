public class SelectionSort {

    static void selectionSort(int[] arr){ // complexity: O(n^2)
        int n = arr.length;
        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            int temp = arr[i];
            for (int j = i; j < n; j++) {
                totalComparisons++;
                if (min > arr[j]) {
                    numComparisons++;
                    min = arr[j];
                    minIndex = j;
                }
            }


            if (arr[minIndex] < temp) {
                arr[i] = min;
                arr[minIndex] = temp;
                numSwaps++;
            }
        }


        System.out.println("The number of swaps after inner loop: "+ numSwaps);
        System.out.println("The number of comparisons after inner loop: "+ numComparisons);
        System.out.println("The total number of comparisons: "+ totalComparisons);
    }

    static void printArray(int[] arr) {

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,9,8,2,7,3,6,4,5,9,10};
        printArray(arr);

        System.out.println("After use selection sort");
        selectionSort(arr);


        printArray(arr);
    }
}