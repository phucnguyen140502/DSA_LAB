package PriorityQApp;

import QueueApp.QueueApp;

import java.util.PriorityQueue;

public class PriorityQueueApp<T> {
    private PriorityQueue<T> priorityQueue;

    public PriorityQueueApp() {
        priorityQueue = new PriorityQueue<>();
    }

    public void displayPriorityQueue() {
        System.out.print("Priority Queue: ");
        for (T item : priorityQueue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public void insert(T item) {

        priorityQueue.add(item);


        System.out.println("Inserted " + item + " at rear");
    }

    public T remove() {
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        QueueApp<Integer> queue = new QueueApp<Integer>(5);

        PriorityQueueApp<Integer> priorityQueue = new PriorityQueueApp<>();

        queue.push(5);
        queue.push(4);
        queue.push(3);
        queue.push(2);
        queue.push(1);

        priorityQueue.insert(5);
        priorityQueue.insert(4);
        priorityQueue.insert(3);
        priorityQueue.insert(2);
        priorityQueue.insert(1);

        queue.displayQueue(); // Last In Last Out
        priorityQueue.displayPriorityQueue(); // // min heap
//                        1
//              2                     4
//        5           3

    }
}
