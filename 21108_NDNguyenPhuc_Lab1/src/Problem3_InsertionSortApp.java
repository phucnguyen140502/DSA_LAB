public class Problem3_InsertionSortApp {

    static void insertionSort(int[] arr){
        int n = arr.length;
        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];

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

    static void printArray(int[] arr) {

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{6,1,7,4,2,9,8,5,3};
        printArray(arr);

        System.out.println("After use insertion sort");
        insertionSort(arr);

        printArray(arr);
    }
}