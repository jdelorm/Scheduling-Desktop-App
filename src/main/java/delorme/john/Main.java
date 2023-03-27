package delorme.john;

import delorme.john.helper.*;
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
            AppointmentsJDBC.getAllAppointments();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            ContactsJDBC.getAllContacts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            CountriesJDBC.getAllCountries();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            CustomersJDBC.getAllCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            FirstLevelDivisionsJDBC.getAllFirstLevelDivisions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            UsersJDBC.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        launch();
        JDBC.closeConnection();

    }
}

