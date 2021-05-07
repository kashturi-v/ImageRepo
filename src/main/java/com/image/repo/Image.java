package com.image.repo;

/**
 * Image is built to store the imageName and imageLocation of each image within
 * a single object, if one wishes to add more information about the images, it
 * can be added to this class.
 */
class Image {
    String imageName;
    String imageLocation;

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageLocation() {
        return this.imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Image(String imageName, String imageLocation) {
        this.imageName = imageName;
        this.imageLocation = imageLocation;
    }
}