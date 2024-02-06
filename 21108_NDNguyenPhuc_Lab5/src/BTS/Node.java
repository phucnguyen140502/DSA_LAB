package BTS;

public class Node {
    private int data;

    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void addToNode(int x){
        if (x < data) {
            if (left == null) {
                left = new Node(x);
            }else{
                left.addToNode(x);
            }
        } else if (x > data) {
            if (right == null) {
                right = new Node(x);
            }else {
                right.addToNode(x);
            }
        }
    }

    public Node deleteNode(int x){
        if (x < data) {
            left = left.deleteNode(x);
        } else if (x > data) {
            right = right.deleteNode(x);
        } else{
            // is leaf
            if (left == null && right == null) {
                return null;
            }

            // One child
            if (left == null) {
                return right;
            } else if (right ==  null) {
                return left;
            }

            // two children
            Node temp = findMin(right);
            data = temp.data;
            right = right.deleteNode(temp.data);
        }
        return this;
    }

    public Node findMin(Node root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node findMax(Node root) {

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }





    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }


    public void setRight(Node right) {
        this.right = right;
    }


    public int getHeight(){
        int heightL;
        if (left == null) {
            heightL = 0;
        }else{
            heightL = left.getHeight();
        }

        int heightR;
        if (right == null) {
            heightR = 0;
        }else{
            heightR = right.getHeight();
        }
        return 1 + Math.max(heightR, heightL);
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    public int amountLeaves(){
        int leaves = 0;

        if (left != null) {
            leaves += left.amountLeaves();
        }
        if (right != null) {
            leaves += right.amountLeaves();
        }
        if (isLeaf()) {
            leaves ++;
        }

        return leaves;
    }

    private boolean checkHeightLR(){
        int heightL;
        if (left == null) {
            heightL = 0;
        }else{
            heightL = left.getHeight();
        }

        int heightR;
        if (right == null) {
            heightR = 0;
        }else{
            heightR = right.getHeight();
        }

        return heightR == heightL;
    }
    public boolean isCompleteTree() {
        if (!checkHeightLR()) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (right == null) {
            return false;
        }

        return left.isCompleteTree() && right.isCompleteTree();
    }

    public boolean isIdentical(Node other){
        if (other.data != data) {
            return false;
        }

        if (left == null) {
            return true;
        }
        if (right == null) {
            return true;
        }

        if (other.left == null) {
            return false;
        }
        if (other.right == null) {
            return false;
        }


        return left.isIdentical(other.left) &&
                right.isIdentical(other.right);
    }

    public void inOrder(){
        if(left != null){
            left.inOrder();
        }
        System.out.format("%d ", data);
        if(right != null){
            right.inOrder();
        }
    }

    public void preOrder(){
        System.out.format("%d ", data);
        if(left != null){
            left.preOrder();
        }

        if(right != null){
            right.preOrder();
        }
    }

    public void postOrder(){

        if(left != null){
            left.postOrder();
        }

        if(right != null){
            right.postOrder();
        }

        System.out.format("%d ", data);
    }


    public Node findNode(int x){
        if (x < data) {
            return left.findNode(x); // Search in left subtree
        } else if (x > data) {
            return right.findNode(x);
        } else{
            return this;
        }
    }



}
