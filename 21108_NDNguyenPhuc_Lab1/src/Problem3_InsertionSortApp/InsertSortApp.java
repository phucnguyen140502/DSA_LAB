package Problem3_InsertionSortApp;

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 10;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        System.out.println("Before Apply Insert Sort");

        arr.insertionSort();          // insertion-sort them

        System.out.println("After Apply Insert Sort");

        arr.display();                // display them again
    }
}
