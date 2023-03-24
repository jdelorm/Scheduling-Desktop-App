package delorme.john.controllers;

import delorme.john.helper.AppointmentsJDBC;
import delorme.john.models.Appointments;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentScreenController implements Initializable {
    public DatePicker appointmentScreenEndDate;
    public DatePicker appointmentScreenStartDate;
    public TextField appointmentScreenUserID;
    public TextField appointmentScreenCustomerID;
    public TextField appointmentScreenType;
    public Button appointmentScreenBackButton;
    public Button appointmentScreenDeleteButton;
    public Button appointmentScreenUpdateButton;
    public Button appointmentScreenAddButton;
    public ComboBox appointmentScreenEndTime;
    public ComboBox appointmentScreenStartTime;
    public TextField appointmentScreenContact;
    public TextField appointmentScreenLocation;
    public TextField appointmentScreenDescription;
    public TextField appointmentScreenTitle;
    public TextField appointmentScreenAptID;
    public TableColumn appointmentScreenUserIDCol;
    public TableColumn appointmentScreenCustomerIDCol;
    public TableColumn appointmentScreenEndDateTimeCol;
    public TableColumn appointmentScreenStartDateTimeCol;
    public TableColumn appointmentScreenTypeCol;
    public TableColumn appointmentScreenContactCol;
    public TableColumn appointmentScreenLocationCol;
    public TableColumn appointmentScreenDescriptionCol;
    public TableColumn appointmentScreenTitleCol;
    public TableColumn appointmentScreenAptIDCol;
    public RadioButton appointmentsScreenAllButton;
    public RadioButton appointmentsScreenWeeklyButton;
    public RadioButton appointmentsScreenMonthlyButton;
    public ComboBox appointmentScreenContactDropDown;
    public TableView appointmentTable;

    public void onAppointmentScreenAptID(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenTitle(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenDescription(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenLocation(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenContact(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenStartTime(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenEndTime(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenAddButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentAddScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Add Customer Appointment");
        stage.setScene(scene);
        stage.show();

    }

    public void onAppointmentScreenUpdateButton(ActionEvent actionEvent) throws IOException {

        Appointments appointmentToModify = (Appointments) appointmentTable.getSelectionModel().getSelectedItem();

        if (appointmentToModify == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("No appointment selected to update");
            alert.showAndWait();

        } else {

            Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentUpdateScreen.fxml"));
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 775, 400);
            stage.setTitle("Update Appointment");
            stage.setScene(scene);
            stage.show();

        }
    }

    public void onAppointmentScreenDeleteButton(ActionEvent actionEvent) {

        delorme.john.models.Appointments selectedAppointments = (Appointments) appointmentTable.getSelectionModel().getSelectedItem();

        if (selectedAppointments == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Select an appointment to delete");
            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete appointment? Action cannot be undone");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                Appointments.deleteAppointments(selectedAppointments);

            }
        }
    }

    public void onAppointmentScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    public void onAppointmentScreenType(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenCustomerID(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenUserID(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenStartDate(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenEndDate(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenAllButton(ActionEvent actionEvent) {
    }

    public void onAppointmentsScreenWeeklyButton(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenMonthlyButton(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenContactDropDown(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointmentTable.setItems(Appointments.getAllAppointments());

        appointmentScreenAptIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsID"));
        appointmentScreenTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsTitle"));
        appointmentScreenDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsDescription"));
        appointmentScreenLocationCol.setCellValueFactory(new PropertyValueFactory<>( "appointmentsLocation"));
        appointmentScreenTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsType"));
        appointmentScreenStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsStartTime"));
        appointmentScreenEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsEndTime"));
        appointmentScreenCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));
        appointmentScreenUserIDCol.setCellValueFactory(new PropertyValueFactory<>("usersID"));
        appointmentScreenContactCol.setCellValueFactory(new PropertyValueFactory<>("contactsID"));

    }
}
