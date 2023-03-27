package delorme.john.helper;

import delorme.john.models.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersJDBC {

    public static ObservableList<Users> getAllUsers() throws SQLException {

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
}
