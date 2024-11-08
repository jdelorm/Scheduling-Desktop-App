package delorme.john.controllers;

import delorme.john.models.Appointments;
import delorme.john.models.Contacts;
import delorme.john.models.Customers;
import delorme.john.models.Users;
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
import java.sql.SQLException;
import java.time.*;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * This class controls the AppointmentAddScreen Scene
 */

public class AppointmentAddScreenController implements Initializable {
    public ComboBox appointmentScreenContactDropDown;
    public DatePicker appointmentScreenEndDate;
    public DatePicker appointmentScreenStartDate;
    public TextField appointmentScreenType;
    public Button appointmentScreenBackButton;
    public Button appointmentScreenAddButton;
    public ComboBox appointmentScreenEndTime;
    public ComboBox appointmentScreenStartTime;
    public TextField appointmentScreenLocation;
    public TextField appointmentScreenDescription;
    public TextField appointmentScreenTitle;
    public TextField appointmentScreenAptID;
    public ComboBox customerIDCombo;
    public ComboBox usersIDCombo;

    /**
     * Method for on action event for onAppointmentScreenAptID
     * @param actionEvent
     */

    public void onAppointmentScreenAptID(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenTitle
     * @param actionEvent
     */

    public void onAppointmentScreenTitle(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenDescription
     * @param actionEvent
     */

    public void onAppointmentScreenDescription(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenLocation
     * @param actionEvent
     */

    public void onAppointmentScreenLocation(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenStartTime
     * @param actionEvent
     */

    public void onAppointmentScreenStartTime(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenEndTime
     * @param actionEvent
     */

    public void onAppointmentScreenEndTime(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerIDCombo
     * @param actionEvent
     */

    public void onCustomerIDCombo(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerIDCombo
     * Checks AddScreen fields for proper inputs and populates them into the AppointmentScreen table
     * Then loads the AppointmentScreen scene after successful appointment creation
     * @param actionEvent
     */

    public void onAppointmentScreenAddButton(ActionEvent actionEvent) {

        try {

            if (appointmentScreenTitle.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Title field should not be empty");
                alert.showAndWait();

            } else if (appointmentScreenDescription.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Description field should not be empty");
                alert.showAndWait();

            } else if (appointmentScreenLocation.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Location field should not be empty");
                alert.showAndWait();

            } else if (appointmentScreenContactDropDown.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a Contact from the dropdown menu to add appointment");
                alert.showAndWait();

            } else if (appointmentScreenType.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Type field should not be empty");
                alert.showAndWait();

            } else if (appointmentScreenStartDate.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a Start Date from the date picker to add appointment");
                alert.showAndWait();

            } else if (appointmentScreenStartTime.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a Start Time from the dropdown menu to add appointment");
                alert.showAndWait();

            } else if (appointmentScreenEndDate.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a End Date from the date picker to update appointment");
                alert.showAndWait();

            } else if (appointmentScreenEndTime.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a End Time from the dropdown menu to add appointment");
                alert.showAndWait();

            } else if (customerIDCombo.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a CustomerID from the dropdown menu to add appointment");
                alert.showAndWait();

            } else if (usersIDCombo.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("UserID field should not be empty");
                alert.showAndWait();

            } else {

                String appointmentsTitle = appointmentScreenTitle.getText();
                String appointmentsDescription = appointmentScreenDescription.getText();
                String appointmentsLocation = appointmentScreenLocation.getText();
                String appointmentsType = appointmentScreenType.getText();
                LocalDateTime appointmentsStartTime = LocalDateTime.of(appointmentScreenStartDate.getValue(), LocalTime.parse(appointmentScreenStartTime.getValue().toString()));
                LocalDateTime appointmentsEndTime = LocalDateTime.of(appointmentScreenEndDate.getValue(), LocalTime.parse(appointmentScreenEndTime.getValue().toString()));
                int customersID = Integer.parseInt(customerIDCombo.getValue().toString());
                int usersID = Integer.parseInt(usersIDCombo.getValue().toString());
                String contactsID = appointmentScreenContactDropDown.getValue().toString();

                boolean appointmentTimeCheck = Appointments.businessTimeAppointmentsVerification(appointmentsStartTime, appointmentsEndTime);
                boolean appointmentOverlapCheck = Appointments.overlappingAppointmentVerification(appointmentsStartTime, appointmentsEndTime);

                if (appointmentTimeCheck == false) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Appointment Date/Time Input Error. Please ensure that:\n\nInput times are within business hours\nAppointment end date/time is AFTER start date/time\nAppointment end time is NOT at the same start time\n\nBusiness hours are between 8:00am to 10:00pm EST.");
                    alert.showAndWait();

                } else if (appointmentOverlapCheck == false) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Appointment Overlap Error.\n\nThere is already an existing appointment for the selected date/time.");
                    alert.showAndWait();

                } else {

                    int appointmentsID = Appointments.getNewAppointmentID();

                    Appointments addNewAppointment = new Appointments(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

                    Appointments.addAppointments(addNewAppointment);

                    Appointments.addNewDataBaseAppointment(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

                    Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root, 775, 400);
                    stage.setTitle("Customer Records");
                    stage.setScene(scene);
                    stage.show();

                }
            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    /**
     * Method for on action event for onAppointmentScreenBackButton
     * Loads the AppointmentScreen scene after pressing the back button
     * @param actionEvent
     * @throws IOException
     */

    public void onAppointmentScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Appointments");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onAppointmentScreenType
     * @param actionEvent
     */

    public void onAppointmentScreenType(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenStartDate
     * @param actionEvent
     */

    public void onAppointmentScreenStartDate(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenEndDate
     * @param actionEvent
     */


    public void onAppointmentScreenEndDate(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenContactDropDown
     * @param actionEvent
     */

    public void onAppointmentScreenContactDropDown(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onUserIDCombo
     * @param actionEvent
     */

    public void onUserIDCombo(ActionEvent actionEvent) {
    }

    /**
     * Initializes the AppointmentAddScreen scene
     * Populates the various combo boxes, drop down menus, and date pickers
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointmentScreenEndDate.setDayCellFactory(picker -> new DateCell() {

            @Override
            public void updateItem(LocalDate datePickerDates, boolean empty) {

                super.updateItem(datePickerDates, empty);

                setDisable(empty || datePickerDates.compareTo(LocalDate.now()) < 0);

            }
        });

        appointmentScreenStartDate.setDayCellFactory(picker -> new DateCell() {

            @Override
            public void updateItem(LocalDate datePickerDates, boolean empty) {

                super.updateItem(datePickerDates, empty);

                setDisable(empty || datePickerDates.compareTo(LocalDate.now()) < 0);

            }
        });

        appointmentScreenStartTime.setItems(Appointments.timeDropDownPopulate());
        appointmentScreenEndTime.setItems(Appointments.timeDropDownPopulate());

        ObservableList<String> contactList = FXCollections.observableArrayList();
        ObservableList<Contacts> contacts = Contacts.getAllContacts();

        if (contacts != null) {

            for (Contacts contact : contacts) {

                contactList.add(String.valueOf(contact.getContactsID()));

            }
        }

        appointmentScreenContactDropDown.setItems(contactList);

        ObservableList<String> customerIDList = FXCollections.observableArrayList();
        ObservableList<Customers> customersID = Customers.getAllCustomers();

        if (customersID != null) {

            for (Customers customers : customersID) {

                customerIDList.add(String.valueOf(customers.getCustomersID()));

            }
        }

        customerIDCombo.setItems(customerIDList);

        ObservableList<String> userIDList = FXCollections.observableArrayList();
        ObservableList<Users> usersID = Users.getAllUsers();

        if (usersID != null) {

            for (Users users : usersID) {

                userIDList.add(String.valueOf(users.getUsersID()));
            }
        }

        usersIDCombo.setItems(userIDList);

    }
}