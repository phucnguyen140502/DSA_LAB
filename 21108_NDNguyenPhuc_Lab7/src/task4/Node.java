package task4;

public class Node{
    private int id;
    private int weight;
    public Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
