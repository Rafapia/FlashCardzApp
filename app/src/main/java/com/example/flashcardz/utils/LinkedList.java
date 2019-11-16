package com.example.flashcardz.utils;

import java.io.Serializable;

public class LinkedList<E> implements Serializable {
    /**
     * Header for the linked list.
     */

    /* Fields */
    private LinkedListNode<E> nextNode;
    private int nodeCount;


    /* Methods */
    // Constructor
    public LinkedList() {
        this.nextNode = null;
        this.nodeCount = 0;
    }



    // Other methods.
    public boolean add(E e) {
        LinkedListNode<E> lastNode = this.getLastNode();

        if (lastNode != null) {
            lastNode.setNextNode(new LinkedListNode<E>(e));
            this.nodeCount++;
        } else {
            this.addFirst(e);   // Already adds to nodeCount!
        }
        return true;
    }

    public boolean add(E[] e) {
        for (E element: e) {
            this.add(element);
        }
        return true;
    }

    public void addFirst(E e) {
        this.nextNode = new LinkedListNode<E>(e, this.nextNode);
        this.nodeCount++;
    }

    public void addLast(E e) {
        this.add(e);
    }

    public void clear() {
        this.nextNode = null;
        this.nodeCount = 0;
    }

    public E get(int index) {
        if (index >= this.size()) {
            return null;
        } else {
            int i = 0;
            LinkedListNode<E> node = this.nextNode;

            while (node.getNextNode() != null && i < index) {
                node = node.getNextNode();
                i++;
            }

            return node.getData();
        }
    }

    public E getFirst() {
        return this.nextNode.getData();
    }

    public E getLast() {
        LinkedListNode<E> lastNode = getLastNode();

        if (lastNode != null) {
            return lastNode.getData();
        }
        return null;
    }

    public void displayList() {
        if (this.nextNode != null) {
            LinkedListNode<E> node = this.nextNode;

            // Walk to the end of List
            while (node.getNextNode() != null) {
                System.out.println(node.getData());
                node = node.getNextNode();
            }

            System.out.println(node.getData());
        }
    }

    public boolean remove(E e) {
        if (this.nextNode != null) {
            LinkedListNode<E> node = this.nextNode;

            // Check if it's first node
            if (node.getData().equals(e)) {
                this.nextNode = node.getNextNode();
                this.nodeCount--;
                return true;
            }

            // Walk to the end of List
            while (node.getNextNode() != null) {
                // if next node matches
                if (node.getNextNode().getData().equals(e)) {
                    node.setNextNode(node.getNextNode().getNextNode());
                    this.nodeCount--;
                    return true;
                }
                node = node.getNextNode();
            }
        }
        return false;
    }

    public E removeFirst() {
        LinkedListNode<E> removedNode = this.nextNode;
        this.nodeCount--;
        if (this.nextNode!=null) {
            this.nextNode = this.nextNode.getNextNode();
            return removedNode.getData();
        }
        return null;
    }

    public E set(int index, E e) {
        if (index >= this.size()) {
            return null;
        } else {
            int i = 0;
            LinkedListNode<E> node = this.nextNode;

            // Walk to index
            while (node.getNextNode() != null && i < index) {
                node = node.getNextNode();
                i++;
            }

            // Set data
            node.setData(e);

            return node.getData();
        }
    }

    public int size() {
        return this.nodeCount;
    }


    // Helper methods
    private LinkedListNode<E> getLastNode() {
        if (this.nextNode != null) {
            LinkedListNode<E> node = this.nextNode;

            // Walk to the end of List
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }

            return node;
        }
        return null;
    }



    /*
        Node class.
     */
    public class LinkedListNode<E> {
        /**
         * Node class for the linked list. Holds data and a pointer to the next node.
         */

        /* Fields */
        private E data;
        private LinkedListNode<E> nextNode;


        /* Methods */
        // Constructor
        public LinkedListNode(E data) {
            this.data = data;
            this.nextNode = null;
        }

        public LinkedListNode(E data, LinkedListNode<E> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }


        // Other methods
        public E getData() {
            return this.data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public LinkedListNode<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(LinkedListNode<E> nextNode) {
            this.nextNode = nextNode;
        }
    }

}

