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

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageNode getPrev() {
        return this.prev;
    }

    public void setPrev(ImageNode prev) {
        this.prev = prev;
    }

    public ImageNode getNext() {
        return this.next;
    }

    public void setNext(ImageNode next) {
        this.next = next;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ImageNode(Image image, int priority) {
        this.image = image;
        this.prev = null;
        this.next = null;
        this.priority = priority;
    }
}