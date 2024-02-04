package Problem1_ApplyLinkedList;

public class StackApp<T> extends DoublyLinkedListApp<T> {
    @Override
    public void add(T element) {
        super.addFirst(element);
        size++;
    }

    @Override
    public T pop() {
        return super.removeFirst();
    }

    @Override
    public T removeLast() {
        return super.removeLast();
    }

    public static void main(String[] args) {
        StackApp<Integer> stack = new StackApp<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.traverse();
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.removeLast());
        System.out.println();
        stack.traverse();
    }
}
