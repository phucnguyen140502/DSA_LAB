package BTS;

public class BTS {
    private Node root;

    private int counts;

    public void addNode(int data){
        counts++;
        if (root == null) {
            root = new Node(data);
        }else{
            root.addToNode(data);
        }
    }

    public Node deleteNode(int data){
        counts--;
        if (root == null) {
            return null;
        }
        else{
            return root.deleteNode(data);
        }
    }

    public int Count(){
        return counts;
    }

    public int getHeight(){
        if (root == null) {
            return 0;
        }else {
            return root.getHeight();
        }
    }

    public int amountLeaves(){
        if (root == null) {
            return 0;
        }else{
            return root.amountLeaves();
        }
    }

    public boolean isCompleteTree() {
        if (root == null) {
            return true;
        }

        else{
            return root.isCompleteTree();
        }
    }

    public boolean isIdentical(BTS otherTree) {
        Node otherRoot = otherTree.root;
        // Both trees are empty, consider them identical
        if (root == null && otherRoot == null) {
            return true;
        }

        // Only one tree is empty, not identical
        if (root == null || otherRoot == null) {
            return false;
        }


        return root.isIdentical(otherRoot);
    }
    public void printInorder(){
        if (root == null) {
            System.out.println("null");
            return;
        }
        root.inOrder();
    }

    public void printPreorder(){
        if (root == null) {
            System.out.println("null");
            return;
        }
        root.preOrder();
    }

    public void printPostorder(){
        if (root == null) {
            System.out.println("null");
            return;
        }
        root.postOrder();
    }


    public int findNode(int key) {
        if (root == null || root.getData() == key) {
            return root.getData(); // Found the node or empty tree
        }

        return root.findNode(key).getData();
    }

    public void clear(){
        root = null;
        counts = 0;
    }

    public int findMinNode(){
        return root.findMin(root).getData();
    }

    public int findMaxNode(){
        return root.findMax(root).getData();
    }




    public static void main(String[] args) {
        BTS Tree1 = new BTS();
        Tree1.addNode(5);
        Tree1.addNode(1);
        Tree1.addNode(2);
        Tree1.addNode(7);
        Tree1.addNode(6);
        Tree1.addNode(8);
        Tree1.addNode(0);


        BTS Tree2 = new BTS();
        Tree2.addNode(5);
        Tree2.addNode(1);
        Tree2.addNode(2);
        Tree2.addNode(7);
        Tree2.addNode(6);
        Tree2.addNode(10);
        Tree2.addNode(0);

        Tree2.printInorder();
        System.out.println(Tree2.deleteNode(5));
        Tree2.printInorder();

        System.out.println(Tree1.isIdentical(Tree2));

        System.out.println(Tree1.Count());

        System.out.println(Tree1.getHeight());

        System.out.println(Tree1.amountLeaves());

        System.out.println(Tree1.isCompleteTree());

        System.out.println(Tree1.findNode(0));

        System.out.println(Tree1.findMinNode());

        System.out.println(Tree1.findMaxNode());

        Tree2.clear(); // clear all the tree
        Tree2.printInorder();
        Tree1.printPostorder();



    }
}
