package delorme.john.controllers;

import delorme.john.helper.appointmentsJDBC;
import delorme.john.models.Appointments;
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
import java.util.ResourceBundle;

import static delorme.john.helper.appointmentsJDBC.getAllAppointments;

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

    /*public void initialize() throws SQLException {

        ObservableList<Appointments> allAppointmentsList = appointmentsJDBC.getAllAppointments();

        appointmentScreenAptIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentScreenTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        appointmentScreenDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        appointmentScreenLocationCol.setCellValueFactory(new PropertyValueFactory<>( "appointmentLocation"));
        appointmentScreenTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        appointmentScreenStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentStartTime"));
        appointmentScreenEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentEndTime"));
        appointmentScreenCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));
        appointmentScreenUserIDCol.setCellValueFactory(new PropertyValueFactory<>("usersID"));
        appointmentScreenContactCol.setCellValueFactory(new PropertyValueFactory<>("contactsID"));

        appointmentTable.setItems(allAppointmentsList);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

        appointmentTable.setItems(appointmentsJDBC.getAllAppointments());

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

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
}
