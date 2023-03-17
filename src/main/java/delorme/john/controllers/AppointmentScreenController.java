package delorme.john.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentScreenController {
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

    public void onAppointmentScreenAddButton(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenUpdateButton(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenDeleteButton(ActionEvent actionEvent) {
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
}
