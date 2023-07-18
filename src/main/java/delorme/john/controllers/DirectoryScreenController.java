package delorme.john.controllers;

import delorme.john.helper.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * This class controls the DirectoryScreen Scene
 */

public class DirectoryScreenController implements Initializable {

    public Button customersDirectory;
    public Button appointmentsDirectory;
    public Button reportsDirectory;
    public Button exitDirectory;
    public Button exit;

    /**
     * Method for on action event for onCustomerDirectory
     * Loads the CustomerScreen scene upon pressing the customer records button
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomersDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onAppointmentDirectory
     * Loads the AppointmentScreen scene upon pressing the customer appointments button
     * @param actionEvent
     * @throws IOException
     */

    public void onAppointmentsDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Appointments");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onReportsDirectory
     * Loads the ReportsScreen scene upon pressing the reports button
     * @param actionEvent
     * @throws IOException
     */

    public void onReportsDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/ReportScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onExitDirectory
     * Loads the MainScreen scene upon pressing the logout button
     * @param actionEvent
     * @throws IOException
     */

    public void onExitDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/MainScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onExit button
     * Closes the application and closes the connection to the JDBC upon pressing the exit program button
     * @param actionEvent
     */

    public void onExit(ActionEvent actionEvent) {

        JDBC.closeConnection();
        System.exit(0);
        
    }

    /**
     * Initializes the DirectoryScreen scene
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}