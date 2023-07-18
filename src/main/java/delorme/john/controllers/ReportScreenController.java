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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * @author John DeLorme
 * This class controls the ReportScreen Scene
 */

public class ReportScreenController implements Initializable {

    public TableColumn reportScreenAptIDCol;
    public TableColumn reportScreenTitleCol;
    public TableColumn reportScreenTypeCol;
    public TableColumn reportScreenDescriptionCol;
    public TableColumn reportScreenStartDateTimeCol;
    public TableColumn reportScreenEndDateTimeCol;
    public TableColumn reportScreenCustomerIDCol;
    public Button reportScreenBackButton;
    public ComboBox reportScreenContactSchedule;
    public TextField reportScreenTypeTotal;
    public TextField reportScreenMonthTotal;
    public ComboBox reportScreenAptType;
    public ComboBox reportScreenAptMonth;
    public TextField recordsScreenTotalApts;
    public TableView reportTable;

    /**
     * Method for on action event for onReportsScreenAptMonth
     * Iterates through the list of appointments by month and displays the total
     * amount of appointments based on the selected month for all years
     * @param actionEvent
     */

    public void onReportScreenAptMonth(ActionEvent actionEvent) {

        ObservableList<Appointments> appointmentsListAll = FXCollections.observableArrayList();
        ObservableList<Appointments> appointmentsListAllRemoveDupes = FXCollections.observableArrayList();

        String selectedMonth = reportScreenAptMonth.getValue().toString();

        Integer totalAppointmentsByMonth = 0;
        Integer totalAppointments = 0;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

            Appointments appointment = i.next();

            if (appointment.getAppointmentsStartTime().getMonth().toString().equalsIgnoreCase(selectedMonth)) {

                appointmentsListAll.add(appointment);

            }
        }

        totalAppointmentsByMonth = appointmentsListAll.size();

        reportScreenMonthTotal.setText(totalAppointmentsByMonth.toString());

        if (reportScreenTypeTotal.getText().isEmpty()) {

            int monthTotalNumber = Integer.parseInt(reportScreenMonthTotal.getText());

            recordsScreenTotalApts.setText(String.valueOf(monthTotalNumber));

        } else if (!reportScreenTypeTotal.getText().isEmpty()) {

            String selectedContactsType = reportScreenAptType.getValue().toString();

            for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

                Appointments appointment = i.next();

                if (appointment.getAppointmentsType().equals(selectedContactsType) &&
                        (appointment.getAppointmentsStartTime().getMonth().toString().equalsIgnoreCase(selectedMonth))) {

                    appointmentsListAll.add(appointment);

                }
            }

            for (Iterator<Appointments> i = appointmentsListAll.iterator(); i.hasNext();) {

                Appointments appointment = i.next();

                if ((!appointmentsListAllRemoveDupes.contains(appointment)) && (appointment.getAppointmentsType().equals(selectedContactsType))) {

                    appointmentsListAllRemoveDupes.add(appointment);

                }
            }

            totalAppointments = appointmentsListAllRemoveDupes.size();
            recordsScreenTotalApts.setText(String.valueOf(totalAppointments));

        }
    }

    /**
     * Method for on action event for onReportScreenAptType
     * Iterates through list of appointments by type and displays the total amount
     * @param actionEvent
     */

    public void onReportScreenAptType(ActionEvent actionEvent) {

        ObservableList<Appointments> appointmentsListAll = FXCollections.observableArrayList();
        ObservableList<Appointments> appointmentsListAllRemoveDupes = FXCollections.observableArrayList();

        String selectedContactsType = reportScreenAptType.getValue().toString();

        Integer totalAppointmentsByType = 0;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

            Appointments appointment = i.next();

            if (appointment.getAppointmentsType().equals(selectedContactsType)) {

                appointmentsListAll.add(appointment);

            }
        }

        totalAppointmentsByType = appointmentsListAll.size();

        reportScreenTypeTotal.setText(totalAppointmentsByType.toString());

        if (reportScreenMonthTotal.getText().isEmpty()) {

            int typeTotalNumber = Integer.parseInt(reportScreenTypeTotal.getText());
            int totalNumber = typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        } else if (!reportScreenMonthTotal.getText().isEmpty()) {

            String selectedMonth = reportScreenAptMonth.getValue().toString();

            Integer totalAppointments = 0;

            for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

                Appointments appointment = i.next();

                if (appointment.getAppointmentsStartTime().getMonth().toString().equalsIgnoreCase(selectedMonth) &&
                        appointment.getAppointmentsType().equals(selectedContactsType)) {

                    appointmentsListAll.add(appointment);

                }
            }

            for (Iterator<Appointments> i = appointmentsListAll.iterator(); i.hasNext();) {

                Appointments appointment = i.next();

                if ((!appointmentsListAllRemoveDupes.contains(appointment)) && (appointment.getAppointmentsType().equals(selectedContactsType))){

                    appointmentsListAllRemoveDupes.add(appointment);

                }
            }

            totalAppointments = appointmentsListAllRemoveDupes.size();
            recordsScreenTotalApts.setText(String.valueOf(totalAppointments));

        }
    }

    /**
     * Method for on action event for onReportScreenMonthTotal
     * @param actionEvent
     */

    public void onReportScreenMonthTotal(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onReportScreenTypeTotal
     * @param actionEvent
     */

    public void onReportScreenTypeTotal(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onReportScreenContactSchedule
     * Iterates through list of appointments based on contacts ID and displays all
     * appointments for selected contacts ID to the table on the ReportsScreen scene
     * @param actionEvent
     */

    public void onReportScreenContactSchedule(ActionEvent actionEvent) {

        ObservableList<Appointments> appointmentsListAll = FXCollections.observableArrayList();

        Integer selectedContactsID = Integer.parseInt(reportScreenContactSchedule.getValue().toString());

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

            Appointments appointment = i.next();

            if (appointment.getContactsID().equals(selectedContactsID.toString())) {

                appointmentsListAll.add(appointment);

            }
        }

        reportTable.setItems(appointmentsListAll);

    }

    /**
     * Method for on action event for onReportScreenBackButton
     * Loads the DirectoryScreen scene upon pressing the back button
     * @param actionEvent
     * @throws IOException
     */

    public void onReportScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onRecordsScreenTotalApts
     * @param actionEvent
     */

    public void onRecordsScreenTotalApts(ActionEvent actionEvent) {
    }

    /**
     * LAMBDA #1
     *
     * Replaced an enhanced for loop that populated the contact id dropdown combo box which
     * uses less code and is easier to read and understand
     *
     * Initializes the ReportScreen scene
     * Populates dropdowns, tables, rows, and columns from database
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        reportScreenAptMonth.setItems(Appointments.monthDropDownPopulate());

        reportTable.setItems(Appointments.getAllAppointments());

        reportScreenAptIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsID"));
        reportScreenTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsTitle"));
        reportScreenDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsDescription"));
        reportScreenTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsType"));
        reportScreenStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsStartTime"));
        reportScreenEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsEndTime"));
        reportScreenCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));

        ObservableList<String> contactList = FXCollections.observableArrayList();
        ObservableList<Contacts> contacts = Contacts.getAllContacts();

        if (contacts != null) {

            contacts.forEach(Contacts -> contactList.add(String.valueOf(Contacts.getContactsID())));

        }

        reportScreenContactSchedule.setItems(contactList);

        ObservableList<String> typeList = FXCollections.observableArrayList();
        ObservableList<Appointments> appointments = Appointments.getAllAppointments();

        if (appointments != null) {

            for (Appointments appointment : appointments) {

                if (!typeList.contains(appointment.getAppointmentsType())) {

                    typeList.add(appointment.getAppointmentsType());

                }
            }
        }

        reportScreenAptType.setItems(typeList);

    }
}