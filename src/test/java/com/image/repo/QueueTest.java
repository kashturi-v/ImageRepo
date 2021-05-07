package com.image.repo;
import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest{
    @Test
    public void createSimpleNullQueue(){
        Queue simpleQueue = new Queue(null, null);
        assertTrue(simpleQueue.head == null && simpleQueue.tail == null);
    }

    @Test
    public void createOneNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        ImageNode imgNode = new ImageNode(img, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
    }

    @Test
    public void createMultipleNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        Image img2 = new Image("TESTER_IMAGE_2", "https://kash.com/tester_2");
        ImageNode imgNode = new ImageNode(img, 1);
        ImageNode imgNode2 = new ImageNode(img2, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode2);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode);
    }

    @Test
    public void popHeadOneNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        ImageNode imgNode = new ImageNode(img, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popHeadQ();
        assertTrue(pop == imgNode);
        assertTrue(simpleQueue.head == null && simpleQueue.tail == null);
    }

    @Test
    public void popHeadMultipleNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        Image img2 = new Image("TESTER_IMAGE_2", "https://kash.com/tester_2");
        ImageNode imgNode = new ImageNode(img, 1);
        ImageNode imgNode2 = new ImageNode(img2, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode2);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popHeadQ();
        assertTrue(pop == imgNode2);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
    }

    @Test
    public void popTailOneNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        ImageNode imgNode = new ImageNode(img, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popTailQ();
        assertTrue(pop == imgNode);
        assertTrue(simpleQueue.head == null && simpleQueue.tail == null);
    }

    @Test
    public void popTailMultipleNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        Image img2 = new Image("TESTER_IMAGE_2", "https://kash.com/tester_2");
        ImageNode imgNode = new ImageNode(img, 1);
        ImageNode imgNode2 = new ImageNode(img2, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode2);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popTailQ();
        assertTrue(pop == imgNode);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode2);
    }

    @Test
    public void popHeadAndTailMultipleNodeQueue(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        Image img2 = new Image("TESTER_IMAGE_2", "https://kash.com/tester_2");
        ImageNode imgNode = new ImageNode(img, 1);
        ImageNode imgNode2 = new ImageNode(img2, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode2);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popHeadQ();
        assertTrue(pop == imgNode2);
        pop = simpleQueue.popTailQ();
        assertTrue(pop == imgNode);
        assertTrue(simpleQueue.head == null && simpleQueue.tail == null);
    }

    @Test
    public void popHeadAndTailMultipleNodeQueue_2(){
        Image img = new Image("TESTER_IMAGE", "https://kash.com/tester");
        Image img2 = new Image("TESTER_IMAGE_2", "https://kash.com/tester_2");
        Image img3 = new Image("TESTER_IMAGE_3", "https://kash.com/tester_3");
        ImageNode imgNode = new ImageNode(img, 1);
        ImageNode imgNode2 = new ImageNode(img2, 1);
        ImageNode imgNode3 = new ImageNode(img3, 1);
        Queue simpleQueue = new Queue(null, null);
        simpleQueue.enterQ(imgNode);
        assertTrue(simpleQueue.head == imgNode && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode2);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode);
        simpleQueue.enterQ(imgNode3);
        assertTrue(simpleQueue.head == imgNode3 && simpleQueue.tail == imgNode);
        ImageNode pop = simpleQueue.popHeadQ();
        assertTrue(pop == imgNode3);
        pop = simpleQueue.popTailQ();
        assertTrue(pop == imgNode);
        assertTrue(simpleQueue.head == imgNode2 && simpleQueue.tail == imgNode2);
    }
    
    
    
}
