package task3;

import task2.Node;

public class Edge<V> extends task2.Edge<V>{


    public Edge(Node<V> source, Node<V> target) {
        super(source, target);
    }

    public Edge(Node<V> source, Node<V> target, int weight) {
        super(source, target, weight);
    }
}