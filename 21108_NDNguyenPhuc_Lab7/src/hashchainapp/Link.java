package hashchainapp;

public class Link
{                                   // (could be other items)
    private int iData;                  // data item
    Link next;                   // next link in list
    // -------------------------------------------------------------
    public Link(int it)                 // constructor
    { iData= it; }
    // -------------------------------------------------------------
    public int getKey()
    { return iData; }
    // -------------------------------------------------------------
    public void displayLink()           // display this link
    { System.out.print(iData + " "); }
}