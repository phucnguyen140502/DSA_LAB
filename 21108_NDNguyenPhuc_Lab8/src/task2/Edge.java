package task2;

public class Edge<V> {
    private Node<V> source;
    private Node<V> target;
    private int weight; // Optional for weighted graphs

    public Edge(Node<V> source, Node<V> target) {
        this.source = source;
        this.target = target;
    }

    public Edge(Node<V> source, Node<V> target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Node<V> getSource() {
        return source;
    }

    public Node<V> getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
    
}