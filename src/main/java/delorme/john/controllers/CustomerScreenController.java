package delorme.john.controllers;

import delorme.john.helper.CustomersJDBC;
import delorme.john.models.Appointments;
import delorme.john.models.Customers;
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
import java.sql.*;
import java.util.*;

public class CustomerScreenController implements Initializable {

    static ObservableList<Customers> customers;

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
    public TableView customerTable;

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

        delorme.john.models.Customers selectedCustomers = (Customers) customerTable.getSelectionModel().getSelectedItem();

        if (selectedCustomers == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Select a customer record to delete");
            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete customer record? Associated customer appointments will also be deleted. Action cannot be undone");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                Customers.deleteCustomers(selectedCustomers);

            }
        }
    }

    public void onCustomerScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerTable.setItems(Customers.getAllCustomers());

        customerScreenIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));
        customerScreenNameCol.setCellValueFactory(new PropertyValueFactory<>("customersName"));
        customerScreenAddressCol.setCellValueFactory(new PropertyValueFactory<>("customersAddress"));
        customerScreenPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>( "customersPostalCode"));
        customerScreenPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customersPhoneNumber"));
        customerScreenCountryCol.setCellValueFactory(new PropertyValueFactory<>("customersCountryData"));
        customerScreenStateCol.setCellValueFactory(new PropertyValueFactory<>("customersDivisionID"));

    }
}
