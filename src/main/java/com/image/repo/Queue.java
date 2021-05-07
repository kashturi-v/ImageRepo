package com.image.repo;

/**
 * Queue is used within each node within the priority queue to keep account of
 * the images for that speicifc user level/ priority. The queue is implemented
 * as a doubly linked list.
 */
class Queue {
    ImageNode head;
    ImageNode tail;

    public ImageNode getHead() {
        return this.head;
    }

    public void setHead(ImageNode head) {
        this.head = head;
    }

    public ImageNode getTail() {
        return this.tail;
    }

    public void setTail(ImageNode tail) {
        this.tail = tail;
    }

    public Queue(ImageNode head, ImageNode tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * @param img (ImageNode) - the new image that is to be added
     * @desc enterQ allows for images to be add to the front of the queue
     * 
     */
    public void enterQ(ImageNode img) {
        if (head == null) {
            this.head = img;
            this.tail = img;
        } else {
            img.next = this.head;
            this.head.prev = img;
            this.head = img;
        }
    }

    /**
     * @desc popTailQ is used to pop off the last node in the queue
     * @return ImageNode - returns the image node that gets deleted
     */
    public ImageNode popTailQ() {
        if (this.tail == null)
            return null;

        ImageNode curr = this.tail;
        this.tail = this.tail.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        return curr;
    }

    /**
     * @desc popHeadQ is used to pop off the first node in the queue
     * @return ImageNode - returns the image node that gets deleted
     */
    public ImageNode popHeadQ() {
        if (this.head == null)
            return null;

        ImageNode curr = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }
        return curr;
    }
}
