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

    public void onReportScreenAptMonth(ActionEvent actionEvent) {

        ObservableList<Appointments> appointmentsListAll = FXCollections.observableArrayList();

        String selectedMonth = reportScreenAptMonth.getValue().toString();

        Integer totalAppointmentsByMonth = 0;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

            Appointments appointment = i.next();

            if (appointment.getAppointmentsStartTime().getMonth().toString().equalsIgnoreCase(selectedMonth)) {

                appointmentsListAll.add(appointment);

            }
        }

        totalAppointmentsByMonth = appointmentsListAll.size();

        reportScreenMonthTotal.setText(totalAppointmentsByMonth.toString());

        if (reportScreenTypeTotal.getText().isEmpty()) {

            int typeTotalNumber = 0;
            int monthTotalNumber = Integer.parseInt(reportScreenMonthTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        } else if (reportScreenMonthTotal.getText().isEmpty()) {

            int monthTotalNumber = 0;
            int typeTotalNumber = Integer.parseInt(reportScreenTypeTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        } else {

            int typeTotalNumber = Integer.parseInt(reportScreenTypeTotal.getText());
            int monthTotalNumber = Integer.parseInt(reportScreenMonthTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        }
    }

    public void onReportScreenAptType(ActionEvent actionEvent) {

        ObservableList<Appointments> appointmentsListAll = FXCollections.observableArrayList();

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

        if (reportScreenTypeTotal.getText().isEmpty()) {

            int typeTotalNumber = 0;
            int monthTotalNumber = Integer.parseInt(reportScreenMonthTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        } else if (reportScreenMonthTotal.getText().isEmpty()) {

            int monthTotalNumber = 0;
            int typeTotalNumber = Integer.parseInt(reportScreenTypeTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        } else {

            int typeTotalNumber = Integer.parseInt(reportScreenTypeTotal.getText());
            int monthTotalNumber = Integer.parseInt(reportScreenMonthTotal.getText());
            int totalNumber = monthTotalNumber + typeTotalNumber;

            recordsScreenTotalApts.setText(String.valueOf(totalNumber));

        }
    }

    public void onReportScreenMonthTotal(ActionEvent actionEvent) {
    }

    public void onReportScreenTypeTotal(ActionEvent actionEvent) {
    }

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

    public void onReportScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    public void onRecordsScreenTotalApts(ActionEvent actionEvent) {
    }

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

            for (Contacts contact : contacts) {

                contactList.add(String.valueOf(contact.getContactsID()));

            }
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
