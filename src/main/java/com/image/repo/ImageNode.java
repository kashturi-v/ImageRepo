package com.image.repo;

/**
 * ImageNode is the node within the doubly linked Queue, each ImageNode refers
 * to the Image, the prev and next node, and the priority.
 */
class ImageNode {
    Image image;
    ImageNode prev;
    ImageNode next;
    int priority;

    public ImageNode(Image image, int priority) {
        this.image = image;
        this.prev = null;
        this.next = null;
        this.priority = priority;
    }
}