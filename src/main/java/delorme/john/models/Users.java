package delorme.john.models;

public class Users {

    public int usersID;
    public String usersName;
    public String usersPassword;

    public Users(int usersID, String usersName, String usersPassword) {

        this.usersID = usersID;
        this.usersName = usersName;
        this.usersPassword = usersPassword;

    }

    public int getUsersID() {

        return usersID;

    }

    public String getUsersName() {

        return usersName;

    }

    public String getUsersPassword() {

        return usersPassword;

    }

    public void setUsersID(int usersID) {

        this.usersID = usersID;

    }

    public void setUsersName(String usersName) {

        this.usersName = usersName;

    }

    public void setUsersPassword(String usersPassword) {

        this.usersPassword = usersPassword;

    }
}
