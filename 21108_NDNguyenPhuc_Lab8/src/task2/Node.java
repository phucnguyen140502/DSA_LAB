package task2;

public class Node<V> {
    private int id;
    private V label;

    public Node(int id, V label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public V getLabel() {
        return label;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(V label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", label=" + label +
                '}';
    }
}