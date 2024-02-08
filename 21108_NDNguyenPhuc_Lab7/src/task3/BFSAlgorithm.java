package task3;

import java.util.*;

public class BFSAlgorithm<V> {

    private Queue<Node<V>> queue;
    private PriorityQueue<Node<V>> priorityQueue;

    private int[] dist;
    private boolean[] visited;
    private Node<V>[] path;

    static int Vertices; // đỉnh
    static int Edges; // cạnh

    private ArrayList<Node<V>>[] graph;
    private HashMap<Edge<V>, Integer> weights;

    public BFSAlgorithm(int capacity) {
        weights = new HashMap<>();
        queue = new LinkedList<>();
        priorityQueue = new PriorityQueue<>(new Comparator<Node<V>>() {
            @Override
            public int compare(Node<V> o1, Node<V> o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        dist = new int[capacity];
        visited = new boolean[capacity];
        path = new Node[capacity];
        graph = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            graph[i] = new ArrayList<>();
        }
    }



    public void minPaths(Node<V> s){
        int indexStart = s.getId();
        for (int i = 0; i < Vertices; i++) {
            visited[i] = false;
            path[i] = null;
        }

        visited[indexStart] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            Node<V> u = queue.peek();
            int indexU = u.getId();
            queue.remove();
            for (int i = 0; i < graph[indexU].size(); i++) {
                Node<V> v = graph[indexU].get(i);
                int indexV = v.getId();
                if (!visited[indexV]) {
                    visited[indexV] = true;
                    queue.add(v);
                    path[indexV] = u;
                }
            }
        }
    }

    public void maxPaths(Node<V> s){
        int indexStart = s.getId();
        for (int i = 0; i < Vertices; i++) {
            visited[i] = false;
            path[i] = null;
        }

        visited[indexStart] = true;
        priorityQueue.add(s);
        while (!priorityQueue.isEmpty()){
            Node<V> u = priorityQueue.peek();
            int indexU = u.getId();
            priorityQueue.remove();
            for (int i = 0; i < graph[indexU].size(); i++) {
                Node<V> v = graph[indexU].get(i);
                int indexV = v.getId();
                if (!visited[indexV]) {
                    visited[indexV] = true;
                    priorityQueue.add(v);
                    path[indexV] = u;
                }
            }
        }
    }

    public int calculateTotalWeight() {
        int totalWeight = 0;
        for (int i = 0; i < path.length - 1; i++) { // Iterate through edges
            Edge<V> edge = new Edge(path[i], path[i + 1]);
            if (weights.containsKey(edge)) {
                totalWeight += weights.get(edge);
            }
        }
        return totalWeight;
    }

    private void printPath(Node<V> s, Node<V> f){
        int pathCount = 0;
        ArrayList<Node<V>> b = new ArrayList<>();
        if (f == s) {
            System.out.println(s);
        }
        if (path[f.getId()] == null) {
            System.out.println("No Path");
        }
        while (true){
            b.add(f);
            f = path[f.getId()];
            pathCount++;
            if (f == s) {
                b.add(f);
                break;
            }
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.println(b.get(i)+" ");
        }
        System.out.println("Number of paths from A to K: "+pathCount);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        BFSAlgorithm<Character> bfsAlgorithm = new BFSAlgorithm<>(74);


        Vertices = sc.nextInt();
        Edges = sc.nextInt();

        for (int i = 0; i < Edges; i++) {
            String uLabel_ = sc.next();
            String vLabel_ = sc.next();
            char uLabel = uLabel_.charAt(0);
            char vLabel = vLabel_.charAt(0);
            int weight = sc.nextInt();
            Node<Character> NodeA = new Node<>((int) vLabel - 65, (char) vLabel);
            Node<Character> NodeB = new Node<>((int) uLabel - 65, (char) uLabel);

            bfsAlgorithm.graph[uLabel - 48].add(NodeA);
            bfsAlgorithm.graph[vLabel - 48].add(NodeB);
            bfsAlgorithm.weights.putIfAbsent(new Edge(NodeA, NodeB), weight); // Add weight (optional)


        }

        Node<Character> start = new Node<>('A' - 48, 'A');
        Node<Character> end = new Node<>('K' - 48, 'K');
        bfsAlgorithm.minPaths(start);
        bfsAlgorithm.printPath(start, end);

        bfsAlgorithm.minPaths(start);
        bfsAlgorithm.printPath(start, end);
        bfsAlgorithm.calculateTotalWeight();

        bfsAlgorithm.maxPaths(start);
        bfsAlgorithm.printPath(start, end);
        bfsAlgorithm.calculateTotalWeight();

    }
}
