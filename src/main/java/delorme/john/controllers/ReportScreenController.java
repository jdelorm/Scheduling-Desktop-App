package delorme.john.controllers;

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
    }

    public void onReportScreenAptType(ActionEvent actionEvent) {
    }

    public void onReportScreenMonthTotal(ActionEvent actionEvent) {
    }

    public void onReportScreenTypeTotal(ActionEvent actionEvent) {
    }

    public void onReportScreenContactSchedule(ActionEvent actionEvent) {
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

        reportTable.setItems(Appointments.getAllAppointments());

        reportScreenAptIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsID"));
        reportScreenTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsTitle"));
        reportScreenDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsDescription"));
        reportScreenTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsType"));
        reportScreenStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsStartTime"));
        reportScreenEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentsEndTime"));
        reportScreenCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));

    }
}
