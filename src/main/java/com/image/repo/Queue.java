package com.image.repo;

class Queue{
    ImageNode head;
    ImageNode tail;

    public Queue(ImageNode head, ImageNode tail){
        this.head = head;
        this.tail = tail;
    }

    public void enterQ(ImageNode img){
        if(head == null)
        {
            this.head = img;
            this.tail = img;
        }
        else{
            img.next = this.head;
            this.head.prev = img;
            this.head = img;
        }
    }

    public ImageNode popTailQ(){
        if(this.tail == null) return null;

        ImageNode curr = this.tail;
        this.tail = this.tail.prev;
        if(this.tail == null){
            this.head = null;
        }
        else{
            this.tail.next = null;
        }
        return curr;
    }

    public ImageNode popHeadQ(){
        if(this.head == null) return null;

        ImageNode curr = this.head;
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
        }
        else{
            this.head.prev = null;
        }
        return curr;
    }
}
