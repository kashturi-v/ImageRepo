//need to add  constructors and files for each of these classes

class Image{
    String imageName;
    String imageLocation;

    public Image(String imageName, String imageLocation){
        this.imageName = imageName;
        this.imageLocation = imageLocation;
    }
}

class ImageNode{
    Image image;
    ImageNode prev;
    ImageNode next;

    public ImageNode(Image image){
        this.image = image;
        this.prev = null;
        this.next = null;
    }
}

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
}

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

public class LRUCache{
    PQNode pqHead;
    PQNode pqTail;

    public LRUCache(){
        this.pqHead = null;
        this.pqTail = null;
    }

    public boolean isEmptyPQ(){
        return this.pqHead == null && this.pqTail == null;
    }

    public void enterPQ(String imageName, String imageLocation, int priority){
        Image newImage = new Image(imageName, imageLocation);
        ImageNode newImageNode = new ImageNode(newImage);
        PQNode currPQNode;
        Queue currQueue = new Queue(newImageNode, newImageNode);
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
                startPQNode = pqHead.next;
                while(startPQNode){
                    if(startPQNode.priority > priority){
                        currPQNode = new PQNode(priority, currQueue, startPQNode.prev, startPQNode);
                        startPQNode.prev.next = currPQNode;
                        startPQNode.prev = currPQNode;
                        return;
                    }
                    else if(startPQNode.priority == priority){
                        startPQNode.num.enterQ();
                    }
                    else{
                        startPQNode = startPQNode.next;
                    }
                }

            }
                
        }
    }

    public void leavePQ(){
        if(isEmptyPQ()){
            System.err.println("Error, image repo is empty");
            return;
        }
        else{
            
        }
    }
}



