package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    private static ObservableList<Users> allUsers = FXCollections.observableArrayList();

    public static ObservableList<Users> getAllUsers() {

        return allUsers;

    }

    public static void setAllUsers(ObservableList<Users> allUsers) {
        Users.allUsers = allUsers;
    }

    public static void addUsers(Users newUsers) {

        allUsers.add(newUsers);
    }
}
