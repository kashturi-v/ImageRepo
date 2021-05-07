package com.image.repo;

public class PQNode{
    int priority;
    Queue num;
    PQNode next;
    PQNode prev;

    public PQNode(int priority, Queue num, PQNode prev, PQNode next){
        this.priority = priority;
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}