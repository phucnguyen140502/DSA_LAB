import java.util.LinkedList;

class HashTable {
    class Entry {
        int key;
        String value;
        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int TABLE_SIZE = 10;
    private LinkedList<Entry>[] table;

    // Constructor
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key){
        return key % TABLE_SIZE;
    }

    // 1. Insert a key-value pair
    public void insert(int key, String value) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Entry(key, value));
    }

    // 2. Delete a key
    public void delete(int key) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                table[index].remove(entry);
                return;
            }
        }
    }

    // 3. Retrieve a value by key
    public String get(int key) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    // Helper method to print the table (optional)
    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print(i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("(" + entry.key + ", " + entry.value + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.insert(3, "Three");
        hashTable.delete(2);
        String value = hashTable.get(1);  // should return "One"
        String missingValue = hashTable.get(2);  // should return null

        System.out.println("Value for key 1: " + value); // Output: One
        System.out.println("Value for key 2: " + missingValue); // Output: null

        hashTable.printTable(); // Optional: Print the table to check the final state
    }
}
