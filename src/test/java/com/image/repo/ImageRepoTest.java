package com.image.repo;

import static org.junit.Assert.*;
import org.junit.Test;

public class ImageRepoTest {

    @Test
    public void createSimpleImageRepoTest() {
        ImageRepo imgRepo = new ImageRepo();
        assertEquals(imgRepo.user.userName ,"Kash");
    }

    @Test
    public void uploadImageTest() {
        ImageRepo imgRepo = new ImageRepo();
        imgRepo.uploadImage("TESTER", "https://www.tester.com/tester");
        assertEquals(imgRepo.imageList.pqHead.num.head.image.imageName,"TESTER");
    }

    @Test
    public void deleteImageTest() {
        ImageRepo imgRepo = new ImageRepo();
        imgRepo.uploadImage("TESTER", "https://www.tester.com/tester");
        assertEquals(imgRepo.imageList.pqHead.num.head.image.imageName ,"TESTER");
        imgRepo.deleteImageBySpecificUser();
        assertEquals(imgRepo.imageList.pqHead , null);
    }

    @Test
    public void getImageTest() {
        ImageRepo imgRepo = new ImageRepo();
        imgRepo.uploadImage("TESTER", "https://www.tester.com/tester");
        assertEquals(imgRepo.imageList.pqHead.num.head.image.imageName , "TESTER");
        assertEquals(imgRepo.getImage("TESTER"), "https://www.tester.com/tester");
    }

    @Test
    public void changeUserTest() {
        ImageRepo imgRepo = new ImageRepo();
        imgRepo.changeUser("Kate", 2);
        assertEquals(imgRepo.user.userName, "Kate");
    }

}
