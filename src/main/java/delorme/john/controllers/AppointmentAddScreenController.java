package delorme.john.controllers;

import delorme.john.models.Appointments;
import delorme.john.models.Contacts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AppointmentAddScreenController implements Initializable {
    public ComboBox appointmentScreenContactDropDown;
    public DatePicker appointmentScreenEndDate;
    public DatePicker appointmentScreenStartDate;
    public TextField appointmentScreenUserID;
    public TextField appointmentScreenCustomerID;
    public TextField appointmentScreenType;
    public Button appointmentScreenBackButton;
    public Button appointmentScreenAddButton;
    public ComboBox appointmentScreenEndTime;
    public ComboBox appointmentScreenStartTime;
    public TextField appointmentScreenLocation;
    public TextField appointmentScreenDescription;
    public TextField appointmentScreenTitle;
    public TextField appointmentScreenAptID;

    public void onAppointmentScreenAptID(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenTitle(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenDescription(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenLocation(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenStartTime(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenEndTime(ActionEvent actionEvent) {
    }

    public void onAppointmentScreenAddButton(ActionEvent actionEvent) {

        if (appointmentScreenContactDropDown.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Must enter a Contact from the dropdown menu to update appointment");
            alert.showAndWait();

        } else if (appointmentScreenStartDate.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Must enter a Start Date from the date picker to update appointment");
            alert.showAndWait();

        } else if (appointmentScreenStartTime.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Must enter a Start Time from the dropdown menu to update appointment");
            alert.showAndWait();

        } else if (appointmentScreenEndDate.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Must enter a End Date from the date picker to update appointment");
            alert.showAndWait();

        } else if (appointmentScreenEndTime.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Must enter a End Time from the dropdown menu to update appointment");
            alert.showAndWait();

        } else {

            try {

                int appointmentsID = Appointments.getNewAppointmentID();
                String appointmentsTitle = appointmentScreenTitle.getText();
                String appointmentsDescription = appointmentScreenDescription.getText();
                String appointmentsLocation = appointmentScreenLocation.getText();
                String appointmentsType = appointmentScreenType.getText();
                LocalDateTime appointmentsStartTime = LocalDateTime.of(appointmentScreenStartDate.getValue(), LocalTime.parse(appointmentScreenStartTime.getValue().toString()));
                LocalDateTime appointmentsEndTime = LocalDateTime.of(appointmentScreenEndDate.getValue(), LocalTime.parse(appointmentScreenEndTime.getValue().toString()));
                int customersID = Integer.parseInt(appointmentScreenCustomerID.getText());
                int usersID = Integer.parseInt(appointmentScreenUserID.getText());
                String contactsID = appointmentScreenContactDropDown.getValue().toString();

                if (appointmentsTitle.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Title field should not be empty");
                    alert.showAndWait();

                } else if (appointmentsDescription.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Description field should not be empty");
                    alert.showAndWait();

                } else if (appointmentsLocation.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Location field should not be empty");
                    alert.showAndWait();

                } else if (appointmentsType.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Type field should not be empty");
                    alert.showAndWait();

                } else if (customersID == 0) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Customer ID field should not be empty");
                    alert.showAndWait();

                } else if (usersID == 0) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Users field should not be empty");
                    alert.showAndWait();

                } else {

                    Appointments addNewAppointment = new Appointments(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

                    Appointments.addAppointments(addNewAppointment);

                    Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root, 775, 400);
                    stage.setTitle("Customer Records");
                    stage.setScene(scene);
                    stage.show();

                }

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }
    }

    public void onAppointmentScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Appointments");
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

    public void onAppointmentScreenContactDropDown(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> timesForBoxes = FXCollections.observableArrayList();
        LocalTime startTimeForPrePopBox = LocalTime.of(7, 0);
        LocalTime endTimeForPrePopBox = LocalTime.of(23, 0);

        timesForBoxes.add(startTimeForPrePopBox.toString());

        while (startTimeForPrePopBox.isBefore(endTimeForPrePopBox)) {

            startTimeForPrePopBox = startTimeForPrePopBox.plusMinutes(15);
            timesForBoxes.add(startTimeForPrePopBox.toString());

        }

        appointmentScreenStartTime.setItems(timesForBoxes);
        appointmentScreenEndTime.setItems(timesForBoxes);

        ObservableList<String> contactList = FXCollections.observableArrayList();

        ObservableList<Contacts> contacts = Contacts.getAllContacts();

        if (contacts != null) {

            for (Contacts contact : contacts) {

                contactList.add(contact.getContactsName());

            }
        }

        appointmentScreenContactDropDown.setItems(contactList);

    }
}
