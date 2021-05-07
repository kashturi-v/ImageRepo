package com.image.repo;

/**
 * PQNode is used to keep account of each priority within the doubly linked
 * queue. Each node holds a LRU queuet that keeps account of all the image's for
 * that specific priority.
 */
public class PQNode {
    // Priorities are based off of user level
    int priority;
    Queue num;
    PQNode next;
    PQNode prev;

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Queue getNum() {
        return this.num;
    }

    public void setNum(Queue num) {
        this.num = num;
    }

    public PQNode getNext() {
        return this.next;
    }

    public void setNext(PQNode next) {
        this.next = next;
    }

    public PQNode getPrev() {
        return this.prev;
    }

    public void setPrev(PQNode prev) {
        this.prev = prev;
    }

    public PQNode(int priority, Queue num, PQNode prev, PQNode next) {
        this.priority = priority;
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}