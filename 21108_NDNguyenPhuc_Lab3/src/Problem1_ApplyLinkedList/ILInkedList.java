package Problem1_ApplyLinkedList;

import java.util.*;

public interface ILInkedList<T> {

    void clear();

    int size();


    boolean isEmpty();

    void add(T element);

    void addFirst(T element);

    void addLast(T element);
    void traverse();

    T peekFirst();

    T peekLast();

    T removeFirst();

    T removeLast();
    T pop();

    T remove(T element);

    T removeAt(int index);

    int indexOf(T element);

    boolean contains(T element);
}
