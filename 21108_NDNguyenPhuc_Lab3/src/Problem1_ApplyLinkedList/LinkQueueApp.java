package Problem1_ApplyLinkedList;

public class LinkQueueApp<T> extends DoublyLinkedListApp<T> {

    @Override
    public void add(T element) { // Add Customer into the queue
        super.add(element);
    }

    @Override
    public T pop() { // Remove the customer in top when finish
        return super.removeFirst();
    }

    @Override
    public T removeAt(int index) { // Remove the Nth customer
        return super.removeAt(index);
    }

    public static void main(String[] args) {
        LinkQueueApp<Integer> queue = new LinkQueueApp<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.traverse();
        System.out.println();
        System.out.println(queue.pop());
        System.out.println();
        queue.traverse();
    }
}
