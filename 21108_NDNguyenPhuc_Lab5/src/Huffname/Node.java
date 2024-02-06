package Huffname;
import java.lang.*;

public class Node implements Comparable<Node>{

    private char ch;
    private int freq;
    private Node left, right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Node o) {
        return freq - o.freq;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
}
