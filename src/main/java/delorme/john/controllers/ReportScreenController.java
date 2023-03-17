package delorme.john.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportScreenController {
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
}
