package Huffname;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffNamCoding {
    private final Map<Character, Integer> freqMap;

    public HuffNamCoding() {
        freqMap = new HashMap<>();
    }

    public Node buildHuffmanTree(String text) {

        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.getFreq() + right.getFreq());
            parent.setLeft(left);
            parent.setRight(right);
            pq.add(parent);
        }

        return pq.poll();  // The root of the Huffman tree
    }

    public static void printTree(Node root, String indent) {
        if (root == null) {
            return;
        }

        System.out.println(indent + " (" + root.getFreq() + ")");
        printTree(root.getLeft(), indent + "  ");
        printTree(root.getRight(), indent + "  ");
    }

    public static void main(String[] args) {
        String text = "I am a student at International University. My name is Nguyen Duc Nguyen Phuc. I am working on a DSA lab";
        HuffNamCoding huffmanCoding = new HuffNamCoding();
        printTree(huffmanCoding.buildHuffmanTree(text), " ");
    }
}