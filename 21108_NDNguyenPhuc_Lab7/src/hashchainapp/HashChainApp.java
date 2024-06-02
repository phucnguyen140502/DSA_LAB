package hashchainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HashChainApp
{
    public static void main(String[] args) throws IOException
    {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        // make table
        HashTable theHashTable = new HashTable(size);

        for(int j=0; j<n; j++)         // insert data
        {
            aKey = (int)(java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }

        // Display the average probe length and load factor after initial filling
        double avgProbeLength = theHashTable.calculateAverageProbeLength();
        double loadFactor = theHashTable.calculateLoadFactor();
        System.out.println("Average Probe Length after initial filling: " + avgProbeLength);
        System.out.println("Load Factor: " + loadFactor);

        while(true)                    // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}


class HashTable
{
    private SortedList[] hashArray;   // array of lists
    private int arraySize;
    private int totalProbes;          // total probes for all inserts
    private int itemCount;            // total items inserted
    // -------------------------------------------------------------
    public HashTable(int size)        // constructor
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];  // create array
        for(int j=0; j<arraySize; j++)          // fill array
            hashArray[j] = new SortedList();     // with lists
        totalProbes = 0;
        itemCount = 0;
    }
    // -------------------------------------------------------------
    public void displayTable()
    {
        for(int j=0; j<arraySize; j++) // for each cell,
        {
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayList(); // display list
        }
    }
    // -------------------------------------------------------------
    public int hashFunc(int key)      // hash function
    {
        return key % arraySize;
    }
    // -------------------------------------------------------------
    public void insert(Link theLink)  // insert a link
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);   // hash the key
        int probes = 1;                // start probe count at 1

        // Probe through the list to find insertion point
        Link current = hashArray[hashVal].first;
        while(current != null && current.getKey() < key) {
            probes++;
            current = current.next;
        }

        hashArray[hashVal].insert(theLink); // insert at hashVal
        totalProbes += probes;          // add probes to total
        itemCount++;                    // increment item count
    }  // end insert()
    // -------------------------------------------------------------
    public void delete(int key)       // delete a link
    {
        int hashVal = hashFunc(key);   // hash the key
        hashArray[hashVal].delete(key); // delete link
    }  // end delete()
    // -------------------------------------------------------------
    public Link find(int key)         // find link
    {
        int hashVal = hashFunc(key);   // hash the key
        Link theLink = hashArray[hashVal].find(key);  // get link
        return theLink;                // return link
    }
    // -------------------------------------------------------------
    public double calculateAverageProbeLength() {
        if (itemCount == 0) return 0;
        return (double) totalProbes / itemCount;
    }
    // -------------------------------------------------------------
    public double calculateLoadFactor() {
        return (double) itemCount / arraySize;
    }
    // -------------------------------------------------------------
}