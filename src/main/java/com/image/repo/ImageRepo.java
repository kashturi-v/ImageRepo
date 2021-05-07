package com.image.repo;

/**
 * ImageRepo is the primary class that is used as the interface to allow
 * multipleusers to uplodad, delete and retrieve images.
 */
public class ImageRepo {
    LRUCache imageList;
    User user;

    public ImageRepo() {
        this.imageList = new LRUCache();
        this.user = new User(1, "Kash");
    }

    public ImageRepo(String userName, int userLevel) {
        this.imageList = new LRUCache();
        this.user = new User(userLevel, userName);
    }

    /**
     * @param imageName (String) - the name of the image
     * @param imageLocation (String) - the location of the image
     * @desc uploadImage is used to upload images to the the system's repository
     */
    public void uploadImage(String imageName, String imageLocation) {
        this.imageList.enterPQ(imageName, imageLocation, this.user.convertPosition());
    }

    /**
     * @desc deleteImage is used to delete images from the system's repository
     */
    public void deleteImage() {
        this.imageList.leavePQ();
    }

    /**
     * @desc deleteImageBySpecificUser is used to delete images only if the current
     * user has the neccesary permissions to do so
     */
    public void deleteImageBySpecificUser() {
        int level = this.user.convertPosition();
        this.imageList.leavePQ(level);
    }

    /**
     * @param imageName (String) - the name of the image
     * @desc deleteSpecificImage is used to delete a specific images only if the
     * current user has the neccesary permissions to do so
     */
    public void deleteSpecificImage(String imageName) {
        int level = this.user.convertPosition();
        this.imageList.deleteImageNode(imageName, level);
    }

    /**
     * @param imageName (String) - the name of the image
     * @desc getImage is used to retrieve the image location according to the image name
     * @return (String) - the location of the image
     */
    public String getImage(String imageName) {
        ImageNode imageNode = this.imageList.getImageNode(imageName);
        return imageNode.image.imageLocation;
    }

    /**
     * @param userName (String) - the new user's name
     * @param userLevel (int) - the new user's level
     * @desc changeUser is used to change the information of the current user who is
     * using the image repo
     */
    public void changeUser(String userName, int userLevel) {
        User newUser = new User(userLevel, userName);
        this.user = newUser;
    }

    /**
     * @desc printList is used as a helper function to print the priority queue out
     *       to the user
     * @return (String) - the text which contains a string output of the priority
     *         queue
     */
    public String printList() {
        return this.imageList.printLRUCache();
    }

    public static void main(String[] args) {

        ImageRepo imageRepo = new ImageRepo();
        imageRepo.uploadImage("TESLA", "https://kash.com/tesla.png");
        imageRepo.uploadImage("MERCEDES", "https://kash.com/mercedes.png");
        imageRepo.uploadImage("BMW", "https://kash.com/bmw.png");
        imageRepo.changeUser("Kate", 3);
        imageRepo.uploadImage("PORSCHE", "https://kate.com/porsche.png");
        imageRepo.uploadImage("LAMBO", "https://kate.com/lambo.png");
        imageRepo.changeUser("Ryan", 2);
        imageRepo.uploadImage("MUSTANG", "https://ryan.com/mustang.png");
        System.out.println(imageRepo.printList());
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteSpecificImage("TESLA");
        System.out.println(imageRepo.getImage("TESLA"));
        System.out.println(imageRepo.printList());
    }
}