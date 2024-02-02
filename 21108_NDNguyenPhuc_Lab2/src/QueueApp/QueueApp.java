package QueueApp;

import java.util.*;

public class QueueApp<T> {

    private int front, rear, size, index = 0;

    private Object[] queueArray;

    private int[] processingTimes;



    public QueueApp(int capacity){
        size = 0;
        queueArray =  new Object[capacity];
        processingTimes = new int[capacity];

    }

    public void push(T element) {
        for (int i = 0; i < queueArray.length; i++) {
            if (queueArray[i] == null) {
                queueArray[i] = element;
                size++;
                break;
            }
        }
    }

    private T elementData(int index) {
        return (T) queueArray[index];
    }

    public synchronized T peek() {
        int len = size();

        if (len == 0){
            throw new EmptyStackException();
        }
        return elementData(0);

    }

    public T pop() {
        T obj = peek();
        for (int i = 0; i < size; i++) {
            queueArray[i] = queueArray[i+1];
        }
        queueArray[size] = null;
        size--;
        return obj;
    }

    public int size(){
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == queueArray.length;
    }
    public void displayQueue() {
        System.out.println("Queue Array:");
        if (empty()) {
            System.out.println("Queue is empty");;
        } else {
            for (int i = 1; i <= size() + 1; i++) {
                front = i - 2;
                rear = i;
                int tempFront = front + 1;
                if (tempFront < size && queueArray[tempFront] != null) {
                    System.out.print(queueArray[tempFront] + " ");
                    tempFront = (tempFront + 1) % queueArray.length;
                    System.out.println("\nFront Index: " + front + ", Rear Index: " + rear);
                }
            }

        }
    }

    public void enqueue(T item, int processingTime) {
        if (isFull()) {
            throw new NoSuchElementException("Queue is full");
        } else {
            push(item);
            processingTimes[index] = processingTime;
            index++;

        }
    }

    public T delayedRemove() {
        if (empty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T Item = pop();
        processingTimes[index] = 0;


        return Item;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The Capacity of Queue: ");
        int capacityOfQueue = sc.nextInt();
        int realCapacity = capacityOfQueue + 2;
        QueueApp<Integer> queue = new QueueApp<Integer>(realCapacity);
        Random random = new Random();
        int time = 0;
        int arrivalTime = 0;
        int serviceTimeRange = 5;

        while (true) {
            // Generate a customer arrival
            if (time % 2 == 0 && arrivalTime < realCapacity- 1) {
                int customerId = arrivalTime;

                int serviceTime = random.nextInt(1,serviceTimeRange) + 1;
                System.out.println("Customer " + customerId + " arrives with service time " + serviceTime + " minutes");
                queue.enqueue(customerId, serviceTime);
                arrivalTime++;

            }

            // Display queue status
            queue.displayQueue();
            System.out.println("----------------");




            time++;

            // Pause for a short time to simulate time passing
            try {
                Thread.sleep(500); // Adjust simulation speed as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!queue.empty() && time % 5 == 0) {

                int processedCustomer = queue.delayedRemove();

                System.out.println("Customer " + processedCustomer + " processed");
            }

            if (queue.empty() && arrivalTime == realCapacity - 1) {
                
                System.out.println("----------------");
                System.out.println("stop transaction");
                break;
            }
        }



    }

}
