import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BST {
    class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private Node root;

    // Constructor
    public BST() {
        root = null;
    }

    // 1. Insert a node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // 2. Find the height of the tree
    public int findHeight() {
        return findHeightRec(root);
    }

    public int findHeightRec(Node root) {
        if (root == null)
            return 0;

        int leftHeight = findHeightRec(root.left);
        int rightHeight = findHeightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 3. Check if the tree is a valid BST
    public boolean isValidBST() {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTRec(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isValidBSTRec(root.left, min, root.data) && isValidBSTRec(root.right, root.data, max);
    }

    // 4. Level-order traversal
    public List<Integer> levelOrderTraversal() {
        return levelOrderTraversalRec(root);
    }

    public List<Integer> levelOrderTraversalRec(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            result.add(node.data);

            if (node.left!= null)
                queue.add(node.left);
            if (node.right!= null)
                queue.add(node.right);
        }

        return result;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        int height = tree.findHeight(); // should return the height of the tree
        System.out.println("Height of the tree: " + height); // Print the height

        boolean isValid = tree.isValidBST(); // should return true if valid
        System.out.println("Is valid BST: " + isValid); // Print if it's a valid BST

        List<Integer> levelOrderList = tree.levelOrderTraversal(); // should return [50, 30, 70, 20, 40, 60, 80]
        System.out.println("Level order traversal: " + levelOrderList); // Print the level-order traversal
    }
}