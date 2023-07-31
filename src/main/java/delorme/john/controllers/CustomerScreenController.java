package delorme.john.controllers;

import delorme.john.models.Customers;
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
import java.util.*;

/**
 * @author John DeLorme
 * This class controls the CustomerScreen Scene
 */

public class CustomerScreenController implements Initializable {

    public TableColumn customerScreenIDCol;
    public TableColumn customerScreenNameCol;
    public TableColumn customerScreenAddressCol;
    public TableColumn customerScreenPostalCodeCol;
    public TableColumn customerScreenPhoneCol;
    public TableColumn customerScreenCountryCol;
    public TableColumn customerScreenStateCol;
    public Button customerScreenAddButton;
    public Button customerScreenUpdateButton;
    public Button customerScreenDeleteButton;
    public Button customerScreenBackButton;
    public TableView customerTable;
    private static Customers customerToModify;

    /**
     * Method to get and return customerToModify
     * @return
     */

    public static Customers getCustomerToModify() {

        return customerToModify;

    }

    /**
     * Method for on action event for onCustomerScreenAddButton
     * Loads the CustomerAddScreen scene upon clicking the add button
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomerScreenAddButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerAddScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Add Customer Record");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method for on action event for onCustomerScreenUpdateButton
     * Checks for customer to update and then loads the CustomerUpdateScreen scene
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomerScreenUpdateButton(ActionEvent actionEvent) throws IOException {

        customerToModify = (Customers) customerTable.getSelectionModel().getSelectedItem();

        if (customerToModify == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("No customer record selected to update");
            alert.showAndWait();

        } else {

            Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerUpdateScreen.fxml"));
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 775, 400);
            stage.setTitle("Update Customer Record");
            stage.setScene(scene);
            stage.show();

        }
    }

    /**
     * Method for on action event for onCustomerScreenDeleteButton
     * Checks for a selection, displays warnings/confirmation dialog boxes if applicable,
     * and then deletes customer and any associated appointments
     * @param actionEvent
     */

    public void onCustomerScreenDeleteButton(ActionEvent actionEvent) throws SQLException {

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

                Customers.deleteAssociatedAppointments(selectedCustomers);
                Customers.deleteCustomers(selectedCustomers);
                Customers.deleteDataBaseCustomer(selectedCustomers.getCustomersID());

            }
        }
    }

    /**
     * Method for on action event for onCustomerScreenBackButton
     * Loads the DirectoryScreen scene upon pressing the back button
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomerScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Directory");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Initializes the CustomerScreen scene
     * Populates the CustomerScreen tables, rows, and columns from database
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerTable.setItems(Customers.getAllCustomers());

        customerScreenIDCol.setCellValueFactory(new PropertyValueFactory<>("customersID"));
        customerScreenNameCol.setCellValueFactory(new PropertyValueFactory<>("customersName"));
        customerScreenAddressCol.setCellValueFactory(new PropertyValueFactory<>("customersAddress"));
        customerScreenPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("customersPostalCode"));
        customerScreenPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customersPhoneNumber"));
        customerScreenStateCol.setCellValueFactory(new PropertyValueFactory<>("customersCountryData"));
        customerScreenCountryCol.setCellValueFactory(new PropertyValueFactory<>("customersDivisionID"));

    }
}