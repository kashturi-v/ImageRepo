package com.image.repo;
import static org.junit.Assert.*;
import org.junit.Test;

public class LRUCacheTest{
    @Test
    public void createSimpleLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
    }

    @Test
    public void addOneNodeSimpleLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);

        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        assertTrue(cache.imageRepo.size() == 1);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
        assertTrue(cache.pqHead.num.tail.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void addMultipleNodesSamePrioritySimpleLRUCacheTest(){
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
    public void addMultipleNodeDifferentPrioritySimpleLRUCacheTest(){
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
    public void addExisitingNodeSimpleLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester_2", 2);
        assertTrue(cache.imageRepo.size() == 1);
    }

    @Test
    public void addPriorityToHeadSimpleLRUCacheTest(){
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
    public void addPriorityToTailSimpleLRUCacheTest(){
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
    public void leaveEmptyLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        assertTrue(cache.leavePQ() == null);
    }

    @Test
    public void invalidPermissionsLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        assertTrue(cache.leavePQ() == null);
    }

    @Test
    public void removeTailWholePriorityLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 2);
        cache.leavePQ();
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqTail.priority == 1);
    }

    @Test
    public void removeAllNodesLRUCacheTest(){
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
    public void deleteImageNodeHeadPQLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.priority == 2);
        assertTrue(cache.pqTail.priority == 2);
    }

    @Test
    public void deleteImageNodeTailPQLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE", 1);
        assertTrue(cache.pqHead.priority == 1);
        assertTrue(cache.pqTail.priority == 1);
    }

    @Test
    public void deleteImageNodeHigherPriorityLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 2);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 2);
        assertTrue(cache.pqHead.priority == 1);
    }

    @Test
    public void deleteImageNodeHeadQueuePQLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void deleteImageNodeTailQueuePQLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.deleteImageNode("TESTER_IMAGE", 1);
        assertTrue(cache.pqHead.num.head.image.imageName == "TESTER_IMAGE_2");
    }

    @Test
    public void deleteImageNodePQLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        cache.enterPQ("TESTER_IMAGE_2", "https://kash.com/tester_2", 1);
        cache.enterPQ("TESTER_IMAGE_3", "https://kash.com/tester_3", 1);
        cache.deleteImageNode("TESTER_IMAGE_2", 1);
        assertTrue(cache.pqHead.num.head.next.image.imageName == "TESTER_IMAGE");
    }

    @Test
    public void getImageNodeDoesNotExistLRUCacheTest(){
        LRUCache cache = new LRUCache();
        assertTrue(cache.imageRepo.size() == 0);
        cache.enterPQ("TESTER_IMAGE", "https://kash.com/tester", 1);
        assertTrue(cache.getImageNode("TESTER_IMAGE_2") == null);
    }

    @Test
    public void getImageNodeUpdateLRUCacheTest(){
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