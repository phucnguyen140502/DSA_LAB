package Problem5_ObjectSortApp;

public class ArrayInOb {
    private Person[] a;               // ref to array a
    private int nElems;               // number of data items

    public ArrayInOb(int max)         // constructor
    {
        a = new Person[max];               // create the array
        nElems = 0;                        // no items yet
    }

    public void insert(String last, String first, int age)
    {
        a[nElems] = new Person(last, first, age);
        nElems++;                          // increment size
    }

    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)  {
            System.out.println(a[j]);
        }
    }
    public void insertionSort(){

        int numSwaps = 0;
        int numComparisons = 0;
        int totalComparisons = 0;

        for (int i = 1; i < nElems; i++) {
            Person temp = a[i];

            // use while loop
            int j = i - 1;
            while (j >= 0){
                totalComparisons++;
                if (temp.getAge() < a[j].getAge()) {
                    numComparisons++;
                    a[j+1] = a[j];
                }else{
                    break;
                }
                j = j - 1;
            }

            a[j+1] = temp;
            numSwaps++;
        }

        System.out.println("The number of swaps after inner loop: "+ numSwaps);
        System.out.println("The number of comparisons after inner loop: "+ numComparisons);
        System.out.println("The total number of comparisons: "+ totalComparisons);

    }

}
