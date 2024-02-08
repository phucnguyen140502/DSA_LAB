package task4;


import java.util.*;

public class DijkstraAlgorithm {

    PriorityQueue<Node> priorityQueue;
    int[] dist;
    int[] path;
    boolean[] visited;
    private ArrayList<Node>[] graph;

    private Character[] label;

    public DijkstraAlgorithm(int capacity) {
        priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        dist = new int[capacity];
        visited = new boolean[capacity];
        path = new int[capacity];
        graph = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            graph[i] = new ArrayList<>();
        }
        label = new Character[capacity];
    }


    public void run(int s, int f) {
        Arrays.fill(dist, 100000000);

        priorityQueue.add(new Node(s, 0));
        dist[s] = 0;

        while (!priorityQueue.isEmpty()) {
            Node top = priorityQueue.poll();
            int u = top.getId();
            int w = top.getWeight();

            if (u == f) {
                break;
            }

            for (int i = 0; i < graph[u].size(); i++) {
                Node neighbor = graph[u].get(i);
                if (w + neighbor.getWeight() < dist[neighbor.getWeight()]) {
                    dist[neighbor.getId()] = w + neighbor.getWeight();
                    priorityQueue.add(new Node(neighbor.getId(), dist[neighbor.getId()]));
                    path[neighbor.getId()] = u;
                }
            }
        }
    }

    private void printPath(int s, int f){
        ArrayList<Integer> b = new ArrayList<>();
        if (f == s) {
            System.out.println(s);
        }
        if (path[f] == -1) {
            System.out.println("No Path");
        }
        while (true){
            b.add(f);
            f = path[f];
            if (f == s) {
                b.add(f);
                break;
            }
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.println(b.get(i)+": "+label[i]+" ");
        }
    }

    public int indexOf(char s){
        int index = 0;
        for (int i = 0; i < label.length; i++) {
            if (s == label[i]) {
                break;
            }
            index++;
        }
        return index;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(13);

//      A: 0, B: 1, C: 2, D: 3, E: 4, F: 5, G: 6, H: 7, I: 8, J: 9, K: 10, L: 11, 2: 12


        for (int i = 0; i < 13; i++) {
            String name = sc.next();
            dijkstraAlgorithm.label[i] = name.charAt(0);

            int neighbors = sc.nextInt();

            for (int j = 0; j < neighbors; j++) {
                int weight = sc.nextInt();
                int k = sc.nextInt();
                dijkstraAlgorithm.graph[i].add(new Node(k, weight));
            }
        }

        String sLabel = sc.next();
        String fLabel = sc.next();
        int s = dijkstraAlgorithm.indexOf(sLabel.charAt(0));
        int f = dijkstraAlgorithm.indexOf(fLabel.charAt(0));
        dijkstraAlgorithm.run(s, f);

    }
}