package hashtable;

import java.util.LinkedList;

public class HashTableApp<K, V> {
    private int tableSize;
    private LinkedList<Node<K, V>>[] table;
    private int probeCount = 0;


    public HashTableApp(int tableSize) {
        this.tableSize = tableSize;
        this.table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return (int) key % tableSize;
    }

    public void insertQuadratic(K key, V value){
        int index = hash(key);

        int i = 0;
        probeCount++;
        while (!table[index].isEmpty()){
            if (table[index].getFirst().getKey() == key) {
                table[index].getFirst().setValue(value);
                return;
            }
            index = (index + i*i) % tableSize; // Quadratic formula
            i++;
        }
        table[index].add(new Node<>(key, value));
    }

    public void insertLinear(K key, V value){
        int index = hash(key);

        probeCount++;
        while (!table[index].isEmpty()){
            if (table[index].getFirst().getKey() == key) {
                table[index].getFirst().setValue(value);
                System.out.println("Probe sequence: " + probeCount);
                return;
            }
            index = (index + probeCount) % tableSize; // Quadratic formula

        }
        System.out.println("Probe sequence: " + probeCount);
        table[index].add(new Node<>(key, value));
    }
    public V find(K key) {
        int index = hash(key);

        probeCount++;
        while (!table[index].isEmpty()) {
            if (table[index].getFirst().getKey() == key) {
                System.out.println("Probe sequence: " + probeCount);
                return table[index].getFirst().getValue();
            }

            index = (index + 1) % tableSize;
        }

        System.out.println("Probe sequence: " + probeCount);
        return null; // Key not found
    }

    public void getAllKey(){
        int index = 0;


        while (!table[index].isEmpty()) {
            System.out.println("Key: "+table[index].getFirst().getKey() +
                    "Value: "+table[index].getFirst().getValue());
            index += 1;
        }
    }
    public void clear(){
        this.table = null;
    }


    public void calculateAverageProbeLength() {
        if (tableSize == 0) {
            System.out.println("Table is empty. Cannot calculate average probe length.");
            return;
        }


        double averageProbeLength = (double) probeCount / tableSize;
        System.out.println("Average probe length: " + averageProbeLength);
    }


    public static void main(String[] args) {
        HashTableApp<Integer, Integer> test = new HashTableApp<Integer, Integer>(10);
        test.calculateAverageProbeLength();
        // test loadFactor
        for (int loadFactor = 25; loadFactor <= 100; loadFactor += 25) {
            int numElements = test.tableSize * loadFactor / 100;
            test.clear(); // Clear the table for each test
            test = new HashTableApp<Integer, Integer>(10);
            System.out.println();
            System.out.println("load Factor: "+loadFactor);
            for (int i = 0; i < numElements; i++) {
                test.insertLinear(i, i); // You can choose either insertLinear or insertQuadratic here
            }


        }
    }


}
