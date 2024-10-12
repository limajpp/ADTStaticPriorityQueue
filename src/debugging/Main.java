package debugging;

import entities.ADTUnorderedStaticPriorityQueue;

public class Main {
    public static void main(String[] args) {
        ADTUnorderedStaticPriorityQueue queue = new ADTUnorderedStaticPriorityQueue(5);

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

        queue.enqueue(76);

        System.out.println(queue);

        System.out.println(queue.contains(75));
        System.out.println(queue.contains(76));
    }
}
