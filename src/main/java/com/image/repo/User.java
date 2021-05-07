package com.image.repo;

/**
 * UserPosition is used to determine the level/priority of each user from highest to lowest priority.
 */
enum UserPosition{
    DIRECTOR,
    PROJECTMANAGER,
    SOFTWAREENGINEER,
    BASELEVELENGINEER
}

/**
 * User is used to keep account of each user, their name and position.
 */
public class User{
    UserPosition userPosition;
    String userName;

    public User(int position, String userName){
        switch(position){
            case 1:
                this.userPosition = UserPosition.DIRECTOR;
                break;
            case 2:
                this.userPosition = UserPosition.PROJECTMANAGER;
                break;
            case 3:
                this.userPosition = UserPosition.SOFTWAREENGINEER;
                break;
            case 4:
                this.userPosition = UserPosition.BASELEVELENGINEER;
                break; 
               
        }
        this.userName = userName;
    }

    
    /**
     * @desc
     *   convertPosition is used to convert the position from a UserPosition to an int for easy 
     *   use within the LRUCache
     * @return
     *   int - the converted position
     */
    public int convertPosition()
    {
        switch(this.userPosition){
            case DIRECTOR:
                return 1;
            case PROJECTMANAGER:
                return 2;
            case SOFTWAREENGINEER:
                return 3;
            default:
                return 4;  
        }
    }

}


