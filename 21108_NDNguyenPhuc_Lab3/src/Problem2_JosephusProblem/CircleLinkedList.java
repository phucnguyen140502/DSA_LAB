package Problem2_JosephusProblem;

import Problem1_ApplyLinkedList.LinkQueueApp;
import Problem1_ApplyLinkedList.Node;

public class CircleLinkedList<T> extends LinkQueueApp<T> {
    @Override
    public void add(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else{
            tail.setNext(new Node<>(element, tail, null));
            tail = tail.getNext();
            tail.setPrevious(tail.getPrevious());

            tail.setNext(head);
            head.setPrevious(tail);
        }
        size++;
    }

    private T skip(T element){ // become
        if (contains(element)) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (currentNode.getData() == element) {

                    currentNode.setData(null);
                    return element;
                }

                currentNode = currentNode.getNext();
            }

        }
        throw new RuntimeException("Not exist in LinkedList");
    }


    public void alive() {
        Node<T> currentNode = head;
        while (currentNode.getData() == null){
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getData());
        clear();
    }

    public void eliminate(int k, int startCounting, int n){
        int index = 1;
        Node<T> current = head;
        while (index < n) {

            if (startCounting % k == 0 && current.getData() != null) {
                System.out.print(skip(current.getData())+" ");
                startCounting++; index ++;
            } else if (current.getData() == null) {
                current = current.getNext();
            }else{
                current = current.getNext();
                startCounting++;
            }
        }

    }


}
