package task2;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph<V> {
    private ArrayList<Node<V>>[] adjacencyList;
    private boolean directed; // Specify if it's directed or undirected

    public Graph(boolean directed, int capacity) {
        this.adjacencyList = new ArrayList[capacity];
        this.directed = directed;
        for (int i = 0; i < capacity; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addNode(Node<V> node) {
        adjacencyList[node.getId()].add(node);
    }

    public void addEdge(Node<V> source, Node<V> target) {
        adjacencyList[source.getId()].add(target);
        if (!directed) {
            adjacencyList[target.getId()].add(source); // Add edge in both directions for undirected graph
        }
    }

    public void getNeighbors(Node<V> e) {
        for (int i = 0; i < adjacencyList[e.getId()].size(); i++) {
            System.out.println(adjacencyList[e.getId()].get(i));
        }
    }

    public boolean isDirected() {
        return directed;
    }

}
