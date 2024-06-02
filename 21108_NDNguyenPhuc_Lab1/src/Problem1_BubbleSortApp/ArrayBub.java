package Problem1_BubbleSortApp;

public class ArrayBub {
    private long[] arr;
    private int nElems;

    public ArrayBub(int max) {
        arr = new long[max];
        nElems = 0;
    }
    public void insert(long value)    // put element into array
    {
        arr[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    private void swap(int one, int two)
    {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public void bubbleSort() { // complexity is O(n(n-1) ==> O(n^2)

        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < nElems - i -1; j++) {
                totalComparisons++;
                if (arr[j] > arr[j + 1]) {
                    numComparisons++;
                    swap(j,j+1);
                    numSwaps++;
                }
            }
        }
        System.out.println("The number of swaps after inner loop: "+numSwaps);
        System.out.println("The number of comparisons after inner loop: "+numComparisons);
        System.out.println("The total number of comparisons: "+totalComparisons);
    }

    public void display() {

        for (long j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
