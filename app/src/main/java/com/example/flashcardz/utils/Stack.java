package com.example.flashcardz.utils;

import java.io.Serializable;

public class Stack<E> implements Serializable {

    /* Fields */
    private LinkedList<E> stack;



    /* Methods */
    // Constructor
    public Stack() {
        this.stack = new LinkedList<E>();
    }


    // Other methods
    public E push(E item) {
        /**
         * Pushes an item onto the top of this stack.
         */
        this.stack.addFirst(item);
        return item;
    }

    public E pop() {
        /**
         * Removes the object at the top of this stack and returns that object as the value of this function.
         */
        return this.stack.removeFirst();
    }

    public E peek() {
        /**
         * Looks at the object at the top of this stack without removing it from the stack.
         */
        return this.stack.getFirst();
    }

    public void display() {
        /**
         * Outputs the stack in order.
         */
        this.stack.displayList();
    }

    public int size() {
        /**
         * Returns number of items in the stack.
         */
        return this.stack.size();
    }

    public boolean isEmpty() {
        /**
         * Checks if stack is currently empty.
         */
        return (this.size() == 0);
    }
}