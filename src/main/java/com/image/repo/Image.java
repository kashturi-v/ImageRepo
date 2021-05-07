package com.image.repo;

/**
 * Image is built to store the imageName and imageLocation of each image within
 * a single object, if one wishes to add more information about the images, it
 * can be added to this class.
 */
class Image {
    String imageName;
    String imageLocation;

    public Image(String imageName, String imageLocation) {
        this.imageName = imageName;
        this.imageLocation = imageLocation;
    }
}