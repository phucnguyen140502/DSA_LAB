public class Problem1_BubbleSortApp {

    static void bubbleSort(int[] arr) { // complexity is O(n(n-1) ==> O(n^2)
        int temp;
        int n = arr.length;
        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                totalComparisons++;
                if (arr[j] > arr[j + 1]) {
                    numComparisons++;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    numSwaps++;
                }
            }
        }
        System.out.println("The number of swaps after inner loop: "+numSwaps);
        System.out.println("The number of comparisons after inner loop: "+numComparisons);
        System.out.println("The total number of comparisons: "+totalComparisons);
    }

    static void printArray(int[] arr) {

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1,6,3,0,5,3};
        printArray(A);


        System.out.println("After use bubble sort");
        bubbleSort(A);

        printArray(A);
    }
}
