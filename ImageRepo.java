public class ImageRepo{
    LRUCache imageList;
    User user;
    public ImageRepo(){
        this.imageList = new LRUCache();
        this.user = new User(1, "Kash");
    }

    public ImageRepo(String userName, int userLevel){
        this.imageList = new LRUCache();
        this.user = new User(userLevel, userName);
    }

    public void uploadImage(String imageName, String imageLocation){
        this.imageList.enterPQ(imageName, imageLocation, this.user.convertPosition());
    }

    public void deleteImage(){
        this.imageList.leavePQ();
    }

    public void deleteImageBySpecificUser(){
        int level = this.user.convertPosition();
        this.imageList.leavePQ(level);
    }

    public void deleteSpecificImage(String imageName){
        int level = this.user.convertPosition();
        this.imageList.deleteImageNode(imageName, level);
    }

    public String getImage(String imageName){
        ImageNode imageNode = this.imageList.getImageNode(imageName);
        return imageNode.image.imageLocation;
    }

    public void changeUser(String userName, int userLevel){
        User newUser = new User(userLevel,userName);
        this.user = newUser;
    }

    public static void main(String[] args){
        
        ImageRepo imageRepo = new ImageRepo();
        imageRepo.uploadImage("TESLA", "https://kash.com/tesla.png");
        imageRepo.uploadImage("MERCEDES", "https://kash.com/mercedes.png");
        imageRepo.uploadImage("BMW", "https://kash.com/bmw.png");
        imageRepo.changeUser("Kate",3);
        imageRepo.uploadImage("PORSCHE", "https://kate.com/porsche.png");
        imageRepo.uploadImage("LAMBO", "https://kate.com/lambo.png");
        imageRepo.changeUser("Ryan",2);
        imageRepo.uploadImage("MUSTANG", "https://ryan.com/mustang.png");
        System.out.println(imageRepo.imageList.printLRUCache());
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteImageBySpecificUser();
        imageRepo.deleteSpecificImage("TESLA");
        System.out.println(imageRepo.getImage("TESLA"));
        System.out.println(imageRepo.imageList.printLRUCache());
    }
}