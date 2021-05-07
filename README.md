# ImageRepo
Fall 2021 - Shopify Backend Developer Challenge

# Summary
A Least-Recently-Used Cache system that allows for multiple users to make various changes to the system's image repository. Users are given priorities according to the position they hold within the company. Priorities are used
to determine whether a user can perform a specific task within the system. Users are prioritized in the following order:

    1. DIRECTOR
    2. PROJECTMANAGER
    3. SOFTWAREENGINEER
    4. BASELEVELENGINEER

A user of a lower level cannot delete an image that a user of a higher level has uploded, as per safety measures.

Images are saved in a priority queue according to the user level, each node within the priority queue has LRU queue, which maintains a list of images for that priority in a least-recently-used manner. Everytime a user uploads a new image or retrieves an old image, the image gets added to the front of the LRU queue. Images are deleted under the following conditions:

    1. Lowest priority that is less than or equal to the current user's priority level.
    2. Least-recently-used image under the lowest priority available.

# Users can perform any of the following tasks

    `changeUser(String userName, String userLevel)` - allows different users to make changes to the system
    `deleteImageBySpecificUser()` - allows a specific user to delete any image of the same priority or lower
    `deleteSpecificImage(String imageName)` - allows a user to delete a specific image if permissions allow
    `uploadImage(String imageName, String imageLocation)` - allows a user to upload a new image at the current user's priority
    `getImage(String imageName)` - get the location of a specific image
    `printList()` - print out the list of image's in the system's repo

# Example
    Simple test case:
    ImageRepo imageRepo = new ImageRepo();
    imageRepo.uploadImage("TESLA", "https://kash.com/tesla.png");
    imageRepo.uploadImage("MERCEDES", "https://kash.com/mercedes.png");
    imageRepo.uploadImage("BMW", "https://kash.com/bmw.png");
    imageRepo.changeUser("Kate",3);
    imageRepo.uploadImage("PORSCHE", "https://kate.com/porsche.png");
    imageRepo.uploadImage("LAMBO", "https://kate.com/lambo.png");
    imageRepo.changeUser("Ryan",2);
    imageRepo.uploadImage("MUSTANG", "https://ryan.com/mustang.png");
    System.out.println(imageRepo.printList());

    Expected Output:
    Priority: 1
        BMW
        MERCEDES
        TESLA
    Priority: 2
        MUSTANG
    Priority: 3
        LAMBO
        PORSCHE

# Running the code 
To run this project, please run the following code in your terminal:
    `javac ImageRepo.java && java ImageRepo`
