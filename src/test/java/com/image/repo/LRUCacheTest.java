package com.image.repo;
import static org.junit.Assert.*;
import org.junit.Test;

public class LRUCacheTest{
    @Test
    public void createSimpleLRUCache(){
        Queue simpleQueue = new Queue(null, null);
        assertTrue(simpleQueue.head == null && simpleQueue.tail == null);
    }
}