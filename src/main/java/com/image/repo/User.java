package com.image.repo;

/**
 * UserPosition is used to determine the level/priority of each user from
 * highest to lowest priority.
 */
enum UserPosition {
    DIRECTOR, PROJECT_MANAGER, SOFTWARE_ENGINEER, BASELEVEL_ENGINEER
}

/**
 * User is used to keep account of each user, their name and position.
 */
public class User {
    UserPosition userPosition;
    String userName;

    public UserPosition getUserPosition() {
        return this.userPosition;
    }

    public void setUserPosition(UserPosition userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(int position, String userName) {
        switch (position) {
            case 1:
                this.userPosition = UserPosition.DIRECTOR;
                break;
            case 2:
                this.userPosition = UserPosition.PROJECT_MANAGER;
                break;
            case 3:
                this.userPosition = UserPosition.SOFTWARE_ENGINEER;
                break;
            case 4:
                this.userPosition = UserPosition.BASELEVEL_ENGINEER;
                break;

        }
        this.userName = userName;
    }

    /**
     * @desc convertPosition is used to convert the position from a UserPosition to
     *       an int for easy use within the LRUCache
     * @return int - the converted position
     */
    public int convertPosition() {
        switch (this.userPosition) {
            case DIRECTOR:
                return 1;
            case PROJECT_MANAGER:
                return 2;
            case SOFTWARE_ENGINEER:
                return 3;
            default:
                return 4;
        }
    }

}
