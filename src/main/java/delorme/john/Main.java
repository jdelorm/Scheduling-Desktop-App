package delorme.john;

import delorme.john.helper.*;
import delorme.john.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        JDBC.openConnection();

        try {
            Appointments.getAllDataBaseAppointments();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Contacts.getAllDataBaseContacts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Countries.getAllDataBaseCountries();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Customers.getAllDataBaseCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            FirstLevelDivisions.getAllDataBaseFirstLevelDivisions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Users.getAllDataBaseUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        launch();
        JDBC.closeConnection();

    }
}