package Problem3_InsertionSortApp;

public class ArrayIns {
    private long[] arr;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        arr = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        arr[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    public void insertionSort(){

        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;

        for (int i = 1; i < nElems; i++) {
            long temp = arr[i];

            // use while loop
            int j = i - 1;
            while (j >= 0){
                totalComparisons++;
                if (temp < arr[j]) {
                    numComparisons++;
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
                j = j - 1;
            }

//            int j = i - 1;
//            while (j >= 0 && temp < arr[j]){
//                totalComparisons++;
//                    arr[j+1] = arr[j];
//                    j = j - 1;
//                }



            // use for loop
//            int k = -1;
//            for (int j = i - 1; j >= 0; j--) {
//                totalComparisons++;
//                if (temp < arr[j]) {
//                    numComparisons++;
//                    arr[j+1] = arr[j];
//                }else{
//                    k = j;
//                    break;
//                }
//            }
            arr[j+1] = temp;
            numSwaps++;
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