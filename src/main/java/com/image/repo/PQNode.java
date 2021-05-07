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

    public PQNode(int priority, Queue num, PQNode prev, PQNode next) {
        this.priority = priority;
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}