enum UserPosition{
    DIRECTOR,
    PROJECTMANAGER,
    SOFTWAREENGINEER,
    BASELEVELENGINEER
}

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

    public int convertPosition()
    {
        switch(this.userPosition){
            case UserPosition.DIRECTOR:
                return 1;
            case UserPosition.PROJECTMANAGER:
                return 2;
            case UserPosition.SOFTWAREENGINEER:
                return 3;
            default:
                return 4;  
        }
    }

}


