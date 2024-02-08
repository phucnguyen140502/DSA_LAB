package task2;

public class MapApp {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(false,6); // Undirected graph

        Node<String> node1 = new Node<>(1, "A");
        Node<String> node2 = new Node<>(2, "B");
        Node<String> node3 = new Node<>(3, "C");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node3);

        graph.getNeighbors(node2);
    }
}
