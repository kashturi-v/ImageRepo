package com.image.repo;

class ImageNode{
    Image image;
    ImageNode prev;
    ImageNode next;
    int priority;

    public ImageNode(Image image, int priority){
        this.image = image;
        this.prev = null;
        this.next = null;
        this.priority = priority;
    }
}