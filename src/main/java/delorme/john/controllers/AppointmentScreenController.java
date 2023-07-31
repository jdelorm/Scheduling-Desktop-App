package delorme.john.controllers;

import delorme.john.models.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * This class controls the AppointmentScreen Scene
 */

public class AppointmentScreenController implements Initializable {

    public Button appointmentScreenBackButton;
    public Button appointmentScreenDeleteButton;
    public Button appointmentScreenUpdateButton;
    public Button appointmentScreenAddButton;
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
    public TableView appointmentTable;

    private static Appointments appointmentToModify;

    /**
     * Method to get and return appointmentToModify
     * @return
     */

    public static Appointments getAppointmentToModify() {

        return appointmentToModify;

    }

    /**
     * Method for on action event for onAppointmentScreenAddButton
     * Loads the AppointmentAddScreen scene on button press
     * @param actionEvent
     * @throws IOException
     */

    public void onAppointmentScreenAddButton(ActionEvent actionEvent) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/AppointmentAddScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 775, 400);
            stage.setTitle("Add Customer Appointment");
            stage.setScene(scene);
            stage.show();

    }

    /**
     * Method for on action event for onAppointmentScreenUpdateButton
     * Upon clicking the update button, the method checks for a selection and then opens the AppointmentUpdateScreen scene
     * @param actionEvent
     * @throws IOException
     */

    public void onAppointmentScreenUpdateButton(ActionEvent actionEvent) throws IOException {

        appointmentToModify = (Appointments) appointmentTable.getSelectionModel().getSelectedItem();

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

    /**
     * Method for on action event for onAppointmentScreenDeleteButton
     * Checks for a selection, then asks for confirmation of decision, and then removes appointment from system
     * @param actionEvent
     */

    public void onAppointmentScreenDeleteButton(ActionEvent actionEvent) throws SQLException {

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

                Appointments.deleteDataBaseAppointment(selectedAppointments.getAppointmentsID());

                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Appointment ID: " + selectedAppointments.getAppointmentsID() + " Type: " + selectedAppointments.getAppointmentsType() + " has been removed.");
                Optional<ButtonType> result2 = alert2.showAndWait();

            }
        }
    }

    /**
     * Method for on action event for onAppointmentScreenBackButton
     * Returns user to the DirectoryScreen scene
     * @param actionEvent
     * @throws IOException
     */

    public void onAppointmentScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onAppointmentScreenAllButton radio button
     * Radio button is pre-selected at load to display all appointments in database in table
     * @param actionEvent
     */

    public void onAppointmentScreenAllButton(ActionEvent actionEvent) {

        try {

            ObservableList<Appointments> appointmentsListAll = Appointments.getAllAppointments();

            if (appointmentsListAll != null)

                    appointmentTable.setItems(appointmentsListAll);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * Method for on action event for onAppointmentScreenWeeklyButton
     * Filters the appointments in database by a weekly basis and displays them in table
     * @param actionEvent
     */

    public void onAppointmentsScreenWeeklyButton(ActionEvent actionEvent) {

        try {

            ObservableList<Appointments> appointmentsListAll = Appointments.getAllAppointments();
            ObservableList<Appointments> appointmentsListWeekly = FXCollections.observableArrayList();

            LocalDateTime startWeekly = LocalDateTime.now().minusWeeks(1);
            LocalDateTime endWeekly = LocalDateTime.now().plusWeeks(1);

            if (appointmentsListAll != null)

                for (Appointments appointments : appointmentsListAll) {

                    if (appointments.getAppointmentsStartTime().isAfter(startWeekly) &&

                            appointments.getAppointmentsEndTime().isBefore(endWeekly)) {

                        appointmentsListWeekly.add(appointments);

                    }

                    appointmentTable.setItems(appointmentsListWeekly);

                };

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * Method for on action event for onAppointmentScreenMonthlyButton
     * Filters the appointments in database on a monthly basis and displays them in the table
     * @param actionEvent
     */

    public void onAppointmentScreenMonthlyButton(ActionEvent actionEvent) {

        try {

            ObservableList<Appointments> appointmentsListAll = Appointments.getAllAppointments();
            ObservableList<Appointments> appointmentsListMonthly = FXCollections.observableArrayList();

            LocalDateTime startMonthly = LocalDateTime.now().minusMonths(1);
            LocalDateTime endMonthly = LocalDateTime.now().plusMonths(1);

            if (appointmentsListAll != null)

                     for (Appointments appointments : appointmentsListAll) {

                    if (appointments.getAppointmentsEndTime().isAfter(startMonthly) &&

                            appointments.getAppointmentsEndTime().isBefore(endMonthly)) {

                        appointmentsListMonthly.add(appointments);

                    }

                    appointmentTable.setItems(appointmentsListMonthly);

                };

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * Initializes the AppointmentScreen scene
     * Populates the table, rows, and columns with appointments in database
     * @param url
     * @param resourceBundle
     */

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