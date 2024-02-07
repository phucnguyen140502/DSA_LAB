package Problem1_ApplyLinkedList;

public class DoublyLinkedListApp<T> implements ILInkedList<T> {

    protected int size;
    protected Node<T> head = null;
    protected Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null){
            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(null);
            currentNode.setPrevious(null);
            currentNode.setData(null);
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
        size++;
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        }else{
            tail.setPrevious(head);
            head = new Node<>(element, null, head);

        }
    }


    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else{
           tail.setNext(new Node<>(element, tail, null));
           tail = tail.getNext();
           tail.setPrevious(tail.getPrevious());
        }
    }

    @Override
    public void traverse() {
        Node<T> currentNode = head;
        while (currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty linked list!");
        }
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty linked list!");
        }
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty linked list!");
        } else{
            T temp = head.getData();
            head = head.getNext();
            size--;
            return temp;
        }
    }

    @Override
    public T removeLast() {

        if (isEmpty()) {
            throw new RuntimeException("Empty linked list!");
        } else {
            T temp = tail.getData();
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return temp;
        }
    }

    @Override
    public T pop() {
        return removeLast();
    }

    @Override
    public T remove(T element) {
        if (contains(element)) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (currentNode.getData() == element) {

                    Node<T> temp = currentNode.getPrevious();
                    temp.setNext(currentNode.getNext());

                    size--;
//                    currentNode.setNext(null);
//                    currentNode.setData(null);
//                    currentNode.setPrevious(null);
                    return element;
                }

                currentNode = currentNode.getNext();
            }

        }
        throw new RuntimeException("Not exist in LinkedList");
    }




        @Override
    public T removeAt(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Out of range LinkedList");
        }

        Node<T> currentNode;
        int i;
        if (index < size() / 2) {
            i = 0;
            currentNode = head;
            while (i != index){
                currentNode = currentNode.getNext();
                i++;
            }
        } else {
            i = size() - 1;
            currentNode = tail;
            while (i != index){
                currentNode = currentNode.getPrevious();
                i--;
            }
        }
        return remove(currentNode.getData());
    }

    @Override
    public int indexOf(T element) {
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null){
            if (currentNode.getData() == element) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public static void main(String[] args) {
        DoublyLinkedListApp<Integer> doublyLinkedList = new DoublyLinkedListApp<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(3);
        doublyLinkedList.traverse();
        System.out.println();
//        System.out.println(doublyLinkedList.remove(2));
        System.out.println();
        doublyLinkedList.traverse();
//        System.out.println(doublyLinkedList.indexOf(1));
        System.out.println();
        System.out.println(doublyLinkedList.remove(2));
        System.out.println();
        doublyLinkedList.traverse();
    }
}
