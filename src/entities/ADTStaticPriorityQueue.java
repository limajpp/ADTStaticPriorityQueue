package entities;

public class ADTStaticPriorityQueue {
    private final Integer[] QUEUE;
    private final int LENGTH;
    private int elements;
    private Integer prioElement;
    private int prioElementIndex;

    public ADTStaticPriorityQueue(int LENGTH) {
        if (LENGTH <= 0) throw new IllegalArgumentException("Invalid length. It must be bigger than zero.");

        this.LENGTH = LENGTH;
        QUEUE = new Integer[LENGTH];
        elements = 0;
        prioElement = null;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean isFull() {
        return elements == LENGTH;
    }

    public boolean prioIsNull() {
        return prioElement == null;
    }

    private int definePrioElement() {
        for (int i = 0; i < elements; i++) {
            prioElement = QUEUE[i];
            for (int j = 0; j < elements; j++) {
                if (prioElement < QUEUE[j]) {
                    prioElement = QUEUE[j];
                }
            }
        }

        return prioElement;
    }

    private int definePrioElementIndex() {
        for (int i = 0; i < elements; i++) {
            if (QUEUE[i].equals(prioElement)) {
                prioElementIndex = i;
                break;
            }
        }

        return prioElementIndex;
    }

    public void enqueue(int element) {
        if (isFull()) throw new IllegalStateException("Queue is full.");

        if (prioIsNull()) {
            prioElement = element;
            QUEUE[0] = element;
            elements++;
        } else {
            prioElement = definePrioElement();
            prioElementIndex = definePrioElementIndex();
            QUEUE[elements] = element;
            elements++;
        }
    }

    public void dequeue() {
        if (isEmpty()) throw new IllegalStateException("List is empty.");

        for (int i = definePrioElementIndex(); i < elements - 1; i++) {
            QUEUE[i] = QUEUE[i + 1];
            QUEUE[i + 1] = null;
        }

        elements--;
        prioElement = definePrioElement();
        prioElementIndex = definePrioElementIndex();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "priorityQueue: []\n";

        StringBuilder priorityQueueString = new StringBuilder("priorityQueue: [");

        for (int i = 0; i < elements; i++) {
            if (i == elements - 1) {
                priorityQueueString.append(QUEUE[i]).append("]\n");
                break;
            }

            priorityQueueString.append(QUEUE[i]).append(", ");
        }

        priorityQueueString.append("LENGTH: ").append(LENGTH).append("\n");
        priorityQueueString.append("elements: ").append(elements).append("\n");
        priorityQueueString.append("prioElement: ").append(prioElement).append("\n");
        priorityQueueString.append("prioElementIndex: ").append(prioElementIndex).append("\n");

        return priorityQueueString.toString();
    }
}
