package com.image.repo;
import java.util.HashMap;

public class LRUCache{
    PQNode pqHead;
    PQNode pqTail;
    HashMap<String, ImageNode> imageRepo;

    public LRUCache(){
        this.pqHead = null;
        this.pqTail = null;
        this.imageRepo = new HashMap<>();
    }

    public boolean isEmptyPQ(){
        return this.pqHead == null && this.pqTail == null;
    }

    public void enterPQ(String imageName, String imageLocation, int priority){
        Image newImage = new Image(imageName, imageLocation);
        ImageNode newImageNode = new ImageNode(newImage, priority);
        PQNode currPQNode;
        Queue currQueue = new Queue(newImageNode, newImageNode);

        if(this.imageRepo.containsKey(imageName)){
            System.out.println("An image with the same name already exists, please choose try again with another name.");
            return;
        }
        this.imageRepo.put(imageName, newImageNode);
        if(this.pqHead == null){
           currPQNode = new PQNode(priority, currQueue, null, null);
           this.pqHead = currPQNode;
           this.pqTail = currPQNode;
        }
        else{
            if(priority < this.pqHead.priority)
            {
                currPQNode = new PQNode(priority, currQueue, null, this.pqHead);
                this.pqHead.prev = currPQNode;
                this.pqHead = currPQNode;
            }
            else if(priority > this.pqTail.priority)
            {
                currPQNode = new PQNode(priority, currQueue, this.pqTail, null);
                this.pqTail.next = currPQNode;
                this.pqTail = currPQNode;
            }
            else
            {
                PQNode startPQNode = pqHead;
                while(startPQNode!=null){
                    if(startPQNode.priority > priority){
                        currPQNode = new PQNode(priority, currQueue, startPQNode.prev, startPQNode);
                        startPQNode.prev.next = currPQNode;
                        startPQNode.prev = currPQNode;
                        return;
                    }
                    else if(startPQNode.priority == priority){
                        startPQNode.num.enterQ(newImageNode);
                        return;
                    }
                    else{
                        startPQNode = startPQNode.next;
                    }
                }

            }
                
        }
    }

    public ImageNode leavePQ(int priority){
        if(isEmptyPQ()){
            System.out.println("Unfortunately, image repo is empty.");
            return null;
        }
        else{
            if(this.pqTail.priority >= priority)
            {
                Queue currQueue = this.pqTail.num;
                ImageNode result = currQueue.popTailQ();
                if(currQueue.head == null)
                {
                    deletePQ(this.pqTail);
                }
                this.imageRepo.remove(result.image.imageName);
                return result;
            }
            System.out.println("Unfortunately, the current user does not have the appropriate permissions to delete any of the saved images.");
            return null;
        }
    }

    public ImageNode leavePQ(){
        if(isEmptyPQ()){
            System.out.println("Unfortunately, image repo is empty.");
            return null;
        }
        else{
            Queue currQueue = this.pqTail.num;
            ImageNode result = currQueue.popTailQ();
            if(currQueue.head == null)
            {
                deletePQ(this.pqTail);
            }
            this.imageRepo.remove(result.image.imageName);
            return result;
            
        }
    }

    public void deletePQ(PQNode deleteNode){
        if(this.pqHead == deleteNode && this.pqTail == deleteNode)
        {
            this.pqHead = null;
            this.pqTail = null;
        }
        else if(this.pqHead == deleteNode){
            this.pqHead = deleteNode.next;
            this.pqHead.prev = null;
        }
        else if(this.pqTail == deleteNode){
            this.pqTail = deleteNode.prev;
            this.pqTail.next = null;
        }
        else{
            deleteNode.prev.next = deleteNode.next;
            deleteNode.next.prev = deleteNode.prev;
        }
    }

    public void deleteImageNode(String imageName, int priority){
        ImageNode imgNode = this.imageRepo.get(imageName);
        if(imgNode.priority < priority){
            System.out.println("Unforutnately, the current user does not have the appropriate permissions to delete image \""+ imageName+"\".");
            return;
        }
        //if this is the case, we know that it exists as a head
        if(imgNode.prev == null){
            PQNode startPQNode = this.pqHead;
            while(startPQNode!=null){
                Queue queue = startPQNode.num;
                System.out.println(startPQNode.priority);
                if(queue.head == imgNode){
                    queue.popHeadQ();
                    //so in the case where its the last node in the queue, we have to delete the queue from the whole PQ
                    if(queue.head == null){
                        deletePQ(startPQNode);
                    }
                    this.imageRepo.remove(imageName);
                    return;
                }
                startPQNode = startPQNode.next;
            }
        }
        else if(imgNode.next == null){ //if this is the case, we know it exists as a tail
            PQNode startPQNode = this.pqHead;
            while(startPQNode!=null){
                Queue queue = startPQNode.num;
                if(queue.tail == imgNode){
                    queue.popTailQ();
                    if(queue.head == null){
                        deletePQ(startPQNode);
                    }
                    this.imageRepo.remove(imageName);
                    return;
                }
                startPQNode = startPQNode.next;
            }
        }
        else{
            ImageNode prevImgNode = imgNode.prev;
            ImageNode nextImgNode = imgNode.next;
            prevImgNode.next = nextImgNode;
            nextImgNode.prev = prevImgNode;
            
        }
        this.imageRepo.remove(imageName);
    }

    public ImageNode getImageNode(String imageName){
        if(this.imageRepo.containsKey(imageName))
        {
            ImageNode imageNode = this.imageRepo.get(imageName);
            Image image = imageNode.image;
            deleteImageNode(imageName, imageNode.priority);
            enterPQ(image.imageName, image.imageLocation, imageNode.priority);
            return imageNode;
        }
        return null;
    }

    public String printLRUCache(){
        String result = "";
        PQNode startNode = this.pqHead;
        while(startNode!=null){
            result += "Priority: " + startNode.priority + "\n";
            ImageNode startImage = startNode.num.head;
            while(startImage!=null){
                result += "\t" + startImage.image.imageName + "\n";
                startImage = startImage.next;
            }
            startNode = startNode.next;
        }
        return result;
    }


}
