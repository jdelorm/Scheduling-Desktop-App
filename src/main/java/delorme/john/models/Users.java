package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author John DeLorme
 * Users class that contains getters, setters, and users info pulled from the database and stores it in a list
 */

public class Users {

    public int usersID;
    public String usersName;
    public String usersPassword;

    public Users(int usersID, String usersName, String usersPassword) {

        this.usersID = usersID;
        this.usersName = usersName;
        this.usersPassword = usersPassword;

    }

    /**
     * Method that pulls user info from datbase and stores it in a list
     * @return
     * @throws SQLException
     */

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

    /**
     * Getter method for getNewPartID
     * @return
     */

    public static int getNewPartID() {

        return userID++;

    }

    /**
     * Getter method for getUsersID
     * @return
     */

    public int getUsersID() {

        return usersID;

    }

    /**
     * Getter method for getUsersName
     * @return
     */

    public String getUsersName() {

        return usersName;

    }

    /**
     * Getter method for getUsersPassword
     * @return
     */

    public String getUsersPassword() {

        return usersPassword;

    }

    /**
     * Setter method for setUsersID
     * @param usersID
     */

    public void setUsersID(int usersID) {

        this.usersID = usersID;

    }

    /**
     * Setter method for setUsersName
     * @param usersName
     */

    public void setUsersName(String usersName) {

        this.usersName = usersName;

    }

    /**
     * Setter method for setUsersPassword
     * @param usersPassword
     */

    public void setUsersPassword(String usersPassword) {

        this.usersPassword = usersPassword;

    }

    /**
     * Method to delete a user
     * @param selectedUsers
     * @return
     */

    public static boolean deleteUsers(Users selectedUsers) {

        if (allUsers.contains(selectedUsers)) {

            allUsers.remove(selectedUsers);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method to update a user
     * @param index
     * @param selectedUsers
     */

    public static void updateUsers(int index, Users selectedUsers) {

        allUsers.set(index, selectedUsers);

    }

    private static ObservableList<Users> allUsers = FXCollections.observableArrayList();

    /**
     * Getter method for getAllUsers
     * @return
     */

    public static ObservableList<Users> getAllUsers() {

        return allUsers;

    }

    /**
     * Setter method for setAllUsers
     * @param allUsers
     */

    public static void setAllUsers(ObservableList<Users> allUsers) {
        Users.allUsers = allUsers;
    }

    /**
     * Method to add a user
     * @param newUsers
     */

    public static void addUsers(Users newUsers) {

        allUsers.add(newUsers);

    }
}