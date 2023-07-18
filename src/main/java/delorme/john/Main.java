package delorme.john;

import delorme.john.helper.*;
import delorme.john.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * Main class
 * Starting point of the program
 */

public class Main extends Application {

    /**
     * Initializes the main class
     * Detects the system locale and loads the MainScreen scene
     * @param stage
     * @throws IOException
     */

    @Override
    public void start(Stage stage) throws IOException {

        ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.getDefault());
        //ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.FRENCH);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle(rb.getString("Login"));
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Opens the connection to the database and pulls all info from database and stores the
     * information in the corresponding class lists, then closes the connection when the program is exited
     * @param args
     */

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