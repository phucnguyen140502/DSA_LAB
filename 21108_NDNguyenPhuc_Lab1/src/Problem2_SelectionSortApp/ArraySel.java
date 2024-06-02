package Problem2_SelectionSortApp;

public class ArraySel {
    private long[] arr;
    private int nElems;

    public ArraySel(int max) {
        arr = new long[max];
        nElems = 0;
    }
    public void insert(long value)    // put element into array
    {
        arr[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    public void selectionSort(){ // complexity: O(n^2)
        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;
        for (int i = 0; i < nElems - 1; i++) {
            long min = arr[i];
            int minIndex = i;
            long temp = arr[i];
            for (int j = i; j < nElems; j++) {
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
        public void display() {

        for (long j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }


}
