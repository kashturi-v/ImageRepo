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
    int priority;

    public ImageNode(Image image, int priority){
        this.image = image;
        this.prev = null;
        this.next = null;
        this.priority = priority;
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
        this.imageRepo.add(imageName, newImageNode);
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
                    this.pqTail = this.pqTail.prev;
                    if(this.pqTail == null)
                    {
                        this.pqHead = null;
                    }
                    else
                    {
                        this.pqTail.next = null;
                    }
                }
                this.imageRepo.remove(result.imageName);
                return result;
            }
            System.out.println("Unfortunately, the current user does not have the right permissions to delete any of these images.")
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
                this.pqTail = this.pqTail.prev;

                if(this.pqTail == null)
                {
                    this.pqHead = null;
                }
                else
                {
                    this.pqTail.next = null;
                }
            }
            this.imageRepo.remove(result.imageName);
            return result;
            
        }
    }

    public void deleteImageNode(String imageName){
        ImageNode imgNode = this.imageRepo.get(imageName);
        //if this is the case, we know that it exists as a head
        if(imgNode.prev == null){
            PQNode startPQNode = this.pqHead;
            while(startPQNode){
                Queue queue = startPQNode.num;
                if(queue.head == imgNode){
                    queue.popHeadQ();
                    this.imageRepo.remove(imageName);
                    return;
                }
                startPQNode = startPQNode.next;
            }
        }
        else if(imgNode.next == null){ //if this is the case, we know it exists as a tail
            PQNode startPQNode = this.pqHead;
            while(startPQNode){
                Queue queue = startPQNode.num;
                if(queue.tail == imgNode){
                    queue.popTailQ();
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
            deleteImageNode(imageName);
            enterPQ(image.imageName, image.imageLocation, imageNode.priority);
            return imageNode;
        }
        return null;
    }


}



