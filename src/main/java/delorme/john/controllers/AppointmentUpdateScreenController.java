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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * This class controls the AppointmentUpdateScreen Scene
 */

public class AppointmentUpdateScreenController implements Initializable {
    public ComboBox appointmentScreenContactDropDown;
    public DatePicker appointmentScreenEndDate;
    public DatePicker appointmentScreenStartDate;
    public TextField appointmentScreenType;
    public Button appointmentScreenBackButton;
    public Button appointmentScreenUpdateButton;
    public ComboBox appointmentScreenEndTime;
    public ComboBox appointmentScreenStartTime;
    public TextField appointmentScreenLocation;
    public TextField appointmentScreenDescription;
    public TextField appointmentScreenTitle;
    public TextField appointmentScreenAptID;
    public ComboBox customerIDCombo;
    public ComboBox usersIDCombo;
    private Appointments selectedAppointments;

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
     * Method for on action event onAppointmentScreenEndTime
     * @param actionEvent
     */

    public void onAppointmentScreenEndTime(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onAppointmentScreenUpdateButton
     * Checks all fields for proper inputs, displays error/confirmation messages if applicable,
     * updates the selected appointment and loads the AppointmentScreen scene
     * @param actionEvent
     */

    public void onAppointmentScreenUpdateButton(ActionEvent actionEvent) {

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

                int appointmentsID = Integer.parseInt(appointmentScreenAptID.getText());
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

                boolean appointmentOverlapCheck = true;

                selectedAppointments = AppointmentScreenController.getAppointmentToModify();

                if ((selectedAppointments.getAppointmentsTitle() != (appointmentsTitle) ||
                        selectedAppointments.getAppointmentsDescription() != (appointmentsDescription) ||
                        selectedAppointments.getAppointmentsLocation() != (appointmentsLocation) ||
                        selectedAppointments.getAppointmentsType() != (appointmentsType) ||
                        selectedAppointments.getContactsID() != (contactsID) ||
                        selectedAppointments.getUsersID() != (usersID) ||
                        selectedAppointments.getCustomersID() != (customersID)) &&
                        (selectedAppointments.getAppointmentsStartTime().toLocalDate().equals(appointmentsStartTime.toLocalDate()) && selectedAppointments.getAppointmentsStartTime().toLocalTime().equals(appointmentsStartTime.toLocalTime()) && selectedAppointments.getAppointmentsEndTime().toLocalDate().equals(appointmentsEndTime.toLocalDate()) && selectedAppointments.getAppointmentsEndTime().toLocalTime().equals(appointmentsEndTime.toLocalTime()))) {

                    appointmentOverlapCheck = true;

                } else {

                    appointmentOverlapCheck = Appointments.overlappingAppointmentVerification(appointmentsStartTime, appointmentsEndTime);

                }

                if ((selectedAppointments.getAppointmentsID()).equals(appointmentsID) &&
                        selectedAppointments.getAppointmentsTitle().equals(appointmentsTitle) &&
                        selectedAppointments.getAppointmentsDescription().equals(appointmentsDescription) &&
                        selectedAppointments.getAppointmentsLocation().equals(appointmentsLocation) &&
                        selectedAppointments.getAppointmentsType().equals(appointmentsType) &&
                        selectedAppointments.getContactsID().equals(contactsID) &&
                        selectedAppointments.getCustomersID().equals(customersID) &&
                        selectedAppointments.getUsersID().equals(usersID) &&
                        selectedAppointments.getAppointmentsStartTime().toLocalDate().equals(appointmentsStartTime.toLocalDate()) &&
                        selectedAppointments.getAppointmentsStartTime().toLocalTime().equals(appointmentsStartTime.toLocalTime()) &&
                        selectedAppointments.getAppointmentsEndTime().toLocalDate().equals(appointmentsEndTime.toLocalDate()) &&
                        selectedAppointments.getAppointmentsEndTime().toLocalTime().equals(appointmentsEndTime.toLocalTime())) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("No changes made");
                    alert.showAndWait();

                } else if (appointmentTimeCheck == false) {

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

                    int index = Appointments.getAllAppointments().indexOf(selectedAppointments);

                    Appointments addNewAppointment = new Appointments(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

                    Appointments.updateAppointments(index, addNewAppointment);

                    Appointments.deleteAppointments(selectedAppointments);

                    Appointments.updateDataBaseAppointment(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

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
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
     * Method for on action event for onCustomerIDCombo
     * @param actionEvent
     */

    public void onCustomerIDCombo(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onUserIDCombo
     * @param actionEvent
     */

    public void onUserIDCombo(ActionEvent actionEvent) {
    }

    /**
     * LAMBDA #2
     *
     * Makes the code look cleaner, is easier to follow, and uses much less code
     *
     * Initializes the AppointmentUpdateScreen scene
     * Populates the combo boxes, dropdowns, date pickers, and text fields with appointment selection to update
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

        selectedAppointments = AppointmentScreenController.getAppointmentToModify();

        appointmentScreenAptID.setText(String.valueOf(selectedAppointments.getAppointmentsID()));
        appointmentScreenTitle.setText(selectedAppointments.getAppointmentsTitle());
        appointmentScreenDescription.setText(selectedAppointments.getAppointmentsDescription());
        appointmentScreenLocation.setText(selectedAppointments.getAppointmentsLocation());
        appointmentScreenType.setText(String.valueOf(selectedAppointments.getAppointmentsType()));
        appointmentScreenContactDropDown.setValue(String.valueOf(selectedAppointments.getContactsID()));
        appointmentScreenStartDate.setValue(selectedAppointments.getAppointmentsStartTime().toLocalDate());
        appointmentScreenStartTime.setValue(selectedAppointments.getAppointmentsStartTime().toLocalTime());
        appointmentScreenEndDate.setValue(selectedAppointments.getAppointmentsEndTime().toLocalDate());
        appointmentScreenEndTime.setValue(selectedAppointments.getAppointmentsEndTime().toLocalTime());
        customerIDCombo.setValue(selectedAppointments.getCustomersID());
        usersIDCombo.setValue(selectedAppointments.getUsersID());

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