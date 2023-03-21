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

public class DirectoryScreenController implements Initializable {
    public Button customersDirectory;
    public Button appointmentsDirectory;
    public Button reportsDirectory;
    public Button exitDirectory;

    public void onCustomersDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();

    }

    public void onAppointmentsDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Appointments");
        stage.setScene(scene);
        stage.show();

    }

    public void onReportsDirectory(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/ReportScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();

    }

    public void onExitDirectory(ActionEvent actionEvent) {

        JDBC.closeConnection();
        System.exit(0);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
