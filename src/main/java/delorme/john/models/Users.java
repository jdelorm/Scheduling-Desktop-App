package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {

    public int usersID;
    public String usersName;
    public String usersPassword;

    public Users(int usersID, String usersName, String usersPassword) {

        this.usersID = usersID;
        this.usersName = usersName;
        this.usersPassword = usersPassword;

    }

    public static ObservableList<Users> getAllDataBaseUsers() throws SQLException {

        ObservableList<Users> usersListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from users";

        PreparedStatement preparedStatementUser = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementUser.executeQuery();

        while (results.next()) {

            int userID = results.getInt("User_ID");
            String userName = results.getString("User_Name");
            String userPassword = results.getString("Password");

            Users newUser = new Users(userID, userName, userPassword);

            Users.addUsers(newUser);

        }

        return usersListQuery;

    }

    private static int userID = 1000;

    public static int getNewPartID() {

        return userID++;

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

    public static boolean deleteUsers(Users selectedUsers) {

        if (allUsers.contains(selectedUsers)) {

            allUsers.remove(selectedUsers);

            return true;

        } else {

            return false;

        }
    }

    public static void updateUsers(int index, Users selectedUsers) {

        allUsers.set(index, selectedUsers);

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
