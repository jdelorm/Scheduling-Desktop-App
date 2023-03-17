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

public class CustomerScreenController {
    public TableColumn customerScreenIDCol;
    public TableColumn customerScreenNameCol;
    public TableColumn customerScreenAddressCol;
    public TableColumn customerScreenPostalCodeCol;
    public TableColumn customerScreenPhoneCol;
    public TableColumn customerScreenCountryCol;
    public TableColumn customerScreenStateCol;
    public TextField customerScreenID;
    public TextField customerScreenName;
    public TextField customerScreenAddress;
    public TextField customerScreenPostalCode;
    public TextField customerScreenPhoneNumber;
    public ComboBox customerScreenStateDropDown;
    public ComboBox customerScreenCountryDropDown;
    public Button customerScreenAddButton;
    public Button customerScreenUpdateButton;
    public Button customerScreenDeleteButton;
    public Button customerScreenBackButton;

    public void onCustomerScreenID(ActionEvent actionEvent) {
    }

    public void onCustomerScreenName(ActionEvent actionEvent) {
    }

    public void onCustomerScreenAddress(ActionEvent actionEvent) {
    }

    public void onCustomerScreenPostalCode(ActionEvent actionEvent) {
    }

    public void onCustomerScreenPhoneNumber(ActionEvent actionEvent) {
    }

    public void onCustomerScreenStateDropDown(ActionEvent actionEvent) {
    }

    public void onCustomerScreenCountryDropDown(ActionEvent actionEvent) {
    }

    public void onCustomerScreenAddButton(ActionEvent actionEvent) {
    }

    public void onCustomerScreenUpdateButton(ActionEvent actionEvent) {
    }

    public void onCustomerScreenDeleteButton(ActionEvent actionEvent) {
    }

    public void onCustomerScreenBackButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();
    }
}
