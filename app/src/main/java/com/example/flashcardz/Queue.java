package com.company;

public class Queue<E> {

    /* Fields */
    private LinkedList<E> queue;



    /* Methods */
    // Constructor
    public Queue() {
        queue = new LinkedList<E>();
    }


    // Other methods
    public E enqueue(E item) {
        /**
         * Pushes an item onto the bottom/back of this queue.
         */
        this.queue.add(item);
        return item;
    }

    public E dequeue() {
        /**
         * Removes the object at the top of this queue and returns that object as the value of this function.
         */
        return this.queue.removeFirst();
    }

    public E peek() {
        /**
         * Looks at the object at the top of this queue without removing it from the queue.
         */
        return this.queue.getFirst();
    }

    public void display() {
        /**
         * Outputs the queue in order.
         */
        this.queue.displayList();
    }

    public int size() {
        /**
         * Returns number of items in the queue.
         */
        return this.queue.size();
    }

    public boolean isEmpty() {
        /**
         * Checks if queue is currently empty.
         */
        return (this.size() == 0);
    }

}