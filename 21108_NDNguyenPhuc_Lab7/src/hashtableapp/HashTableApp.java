package hashtableapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        // make table
        HashTable theHashTable = new HashTable(size);

        for(int j=0; j<n; j++)        // insert data
        {
            aKey = (int)(java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        while(true)                   // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, find, insertLinear, insertQuadratic, avgProbe: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
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
                    {
                        System.out.println("Found " + aKey);
                    }
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                case 'l':
                    System.out.print("Enter key value to insert (linear probing): ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insertLinear(aDataItem);
                    break;
                case 'q':
                    System.out.print("Enter key value to insert (quadratic probing): ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insertQuadratic(aDataItem);
                    break;
                case 'a':
                    double avgProbeLength = theHashTable.calculateAverageProbeLength();
                    System.out.println("Average Probe Length: " + avgProbeLength);
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
    //--------------------------------------------------------------
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
//--------------------------------------------------------------
}  // end class HashTableApp

class HashTable
{
    private DataItem[] hashArray;    // array holds hash table
    private int arraySize;
    private DataItem nonItem;        // for deleted items
    private int probeCount;          // to count probes
    private int itemCount;           // to count items inserted
    // -------------------------------------------------------------
    public HashTable(int size)       // constructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);   // deleted item key is -1
        probeCount = 0;
        itemCount = 0;
    }
    // -------------------------------------------------------------
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public int hashFunc(int key)
    {
        return key % arraySize;       // hash function
    }
    // -------------------------------------------------------------
    public void insert(DataItem item) // insert a DataItem
    {
        int key = item.getKey();      // extract key
        int hashVal = hashFunc(key);  // hash the key
        int probes = 1;               // initialize probe count

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
            probes++;
        }
        hashArray[hashVal] = item;    // insert item
        probeCount += probes;         // add to total probes
        itemCount++;                  // increment item count
    }  // end insert()
    // -------------------------------------------------------------
    public void insertLinear(DataItem item) // insert a DataItem with linear probing
    {
        int key = item.getKey();      // extract key
        int hashVal = hashFunc(key);  // hash the key
        int probes = 1;               // initialize probe count

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
            probes++;
        }
        hashArray[hashVal] = item;    // insert item
        probeCount += probes;         // add to total probes
        itemCount++;                  // increment item count
    }  // end insertLinear()
    // -------------------------------------------------------------
    public void insertQuadratic(DataItem item) // insert a DataItem with quadratic probing
    {
        int key = item.getKey();      // extract key
        int hashVal = hashFunc(key);  // hash the key
        int probes = 1;               // initialize probe count
        int i = 1;                    // quadratic increment

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1)
        {
            hashVal += i * i;          // quadratic probing
            hashVal %= arraySize;      // wraparound if necessary
            i++;
            probes++;
        }
        hashArray[hashVal] = item;    // insert item
        probeCount += probes;         // add to total probes
        itemCount++;                  // increment item count
    }  // end insertQuadratic()
    // -------------------------------------------------------------
    public DataItem delete(int key)  // delete a DataItem
    {
        int hashVal = hashFunc(key);  // hash the key

        while(hashArray[hashVal] != null)  // until empty cell,
        {                               // found the key?
            if(hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;       // delete item
                return temp;                        // return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't find item
    }  // end delete()
    // -------------------------------------------------------------
    public DataItem find(int key)    // find item with key
    {
        int hashVal = hashFunc(key);  // hash the key

        while(hashArray[hashVal] != null)  // until empty cell,
        {                               // found the key?
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];   // yes, return item
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't find item
    }
    // -------------------------------------------------------------
    public double calculateAverageProbeLength() {
        if (itemCount == 0) return 0;
        return (double) probeCount / itemCount;
    }
    // -------------------------------------------------------------
}
