package com.image.repo;
import static org.junit.Assert.*;
import org.junit.Test;

public class LRUCacheTest{
    @Test
    public void createSimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
    }

    @Test
    public void addOneNodeSimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);

        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        assertTrue(cache.imageRepo.size() == 1);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
        assertTrue(cache.pqHead.num.tail.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void addMultipleNodesSamePrioritySimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);

        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        assertTrue(cache.imageRepo.size() == 2);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE_2");
        assertTrue(cache.pqHead.num.tail.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void addMultipleNodeDifferentPrioritySimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);

        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 2);
        assertTrue(cache.imageRepo.size() == 2);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
        assertTrue(cache.pqTail.num.tail.image.imageName == "TESTER_IMAGE_2");
    }

    @Test
    public void addExisitingNodeSimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester_2", 2);
        assertTrue(cache.imageRepo.size() == 1);
    }

    @Test
    public void addPriorityToHeadSimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        assertTrue(cache.imageRepo.size() == 2);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE_2");
        assertTrue(cache.pqTail.num.tail.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void addPriorityToTailSimpleLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 2);
        assertTrue(cache.imageRepo.size() == 2);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
        assertTrue(cache.pqTail.num.tail.image.imageName == "TESTER_IMAGE_2");
    }

    @Test
    public void leaveEmptyLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        assertTrue(cache.leavePQ() == null);
    }

    @Test
    public void invalidPermissionsLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        assertTrue(cache.leavePQ() == null);
    }

    @Test
    public void removeTailWholePriorityLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 2);
        cache.leavePQ();
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqTail.priority == 1);
    }

    @Test
    public void removeAllNodesLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.leavePQ();
        cache.leavePQ();
        assertTrue(cache.pqHead == null);
        assertTrue(cache.pqTail == null);
    }

    @Test
    public void deleteImageNodeHeadPQLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.priority == 2);
        assertTrue(cache.pqTail.priority == 2);
    }

    @Test
    public void deleteImageNodeTailPQLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE", 1);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqTail.priority == 1);
    }

    @Test
    public void deleteImageNodeHigherPriorityLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 2);
        assertTrue(cache.pqHead.priority == 1);
    }

    @Test
    public void deleteImageNodeHeadQueuePQLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void deleteImageNodeTailQueuePQLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE", 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE_2");
    }

    @Test
    public void deleteImageNodePQLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.enterPQ("TESTER_IMAGE_3", "https://kash.com/tester_3", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.num.head.next.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void getImageNodeDoesNotExistLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        assertTrue(cache.getImageNode("TESTER_IMAGE_2") == null);
    }

    @Test
    public void getImageNodeUpdateLRUCache(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.enterPQ("TESTER_IMAGE_3", "https://kash.com/tester_3", 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE_3");
        cache.getImageNode("TESTER_IMAGE");
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
    }


}