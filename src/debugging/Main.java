package debugging;

import entities.ADTStaticPriorityQueue;

public class Main {
    public static void main(String[] args) {
        ADTStaticPriorityQueue queue = new ADTStaticPriorityQueue(5);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println(queue);

        queue.enqueue(1);
        queue.enqueue(-2);
        queue.enqueue(-3);
        queue.enqueue(9);
        queue.enqueue(4);

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);
    }
}
