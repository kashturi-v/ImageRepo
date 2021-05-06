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
        this.imageList.deleteImageNode(imageName);
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
        //have command line input
        ImageRepo imageRepo = new ImageRepo();

    }
}