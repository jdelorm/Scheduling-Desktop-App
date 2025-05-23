package delorme.john.controllers;

import delorme.john.models.Countries;
import delorme.john.models.Customers;
import delorme.john.models.FirstLevelDivisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static delorme.john.models.FirstLevelDivisions.lookupDivisions;

/**
 * @author John DeLorme
 * This class controls the CustomerUpdateScreen Scene
 */

public class CustomerUpdateScreenController implements Initializable {
    public Button customerScreenBackButton;
    public Button customerScreenUpdateButton;
    public ComboBox customerScreenCountryDropDown;
    public ComboBox customerScreenStateDropDown;
    public TextField customerScreenPhoneNumber;
    public TextField customerScreenPostalCode;
    public TextField customerScreenAddress;
    public TextField customerScreenName;
    public TextField customerScreenID;
    private Customers selectedCustomer;

    /**
     * Method for on action event for onCustomerScreenID
     * @param actionEvent
     */

    public void onCustomerScreenID(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenName
     * @param actionEvent
     */

    public void onCustomerScreenName(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenAddress
     * @param actionEvent
     */

    public void onCustomerScreenAddress(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenPostalCode
     * @param actionEvent
     */

    public void onCustomerScreenPostalCode(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenPhoneNumber
     * @param actionEvent
     */

    public void onCustomerScreenPhoneNumber(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenStateDropDown
     * @param actionEvent
     */

    public void onCustomerScreenStateDropDown(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenCountryDropDown
     * Converts country code to country abbreviations and filters the state selection dropdown based on
     * the selection made in the country selection dropdown
     * @param actionEvent
     */

    public void onCustomerScreenCountryDropDown(ActionEvent actionEvent) {

        String q = customerScreenCountryDropDown.getValue().toString();

        if (q.equals("1") || q.equals("U.S")) {

            q = "1";

        } else if (q.equals("2") || q.equals("UK")) {

            q = "2";

        } else {

            q = "3";

        }

        ObservableList<String> firstLevelDivisionsList = FXCollections.observableArrayList();

        ObservableList<FirstLevelDivisions> filteredDivisions = lookupDivisions(q);

        if (filteredDivisions != null) {

            for (FirstLevelDivisions division : filteredDivisions) {

                firstLevelDivisionsList.add(division.getDivisions());

            }
        }

        customerScreenStateDropDown.setItems(firstLevelDivisionsList);

    }

    /**
     * Method for on action event for onCustomerScreenUpdateButton
     * Checks fields for proper selection, displays warnings if applicable,
     * updates customer in database, and then loads the CustomerScreen scene
     * @param actionEvent
     */

    public void onCustomerScreenUpdateButton(ActionEvent actionEvent) {

        try {

            if (customerScreenName.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Name field should not be empty");
                alert.showAndWait();

            } else if (customerScreenAddress.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Address field should not be empty");
                alert.showAndWait();

            } else if (customerScreenPostalCode.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Postal Code field should not be empty");
                alert.showAndWait();

            } else if (customerScreenPhoneNumber.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Phone Number field should not be empty");
                alert.showAndWait();

            } else if (customerScreenCountryDropDown.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a Country from the dropdown menu to create customer record");
                alert.showAndWait();

            } else if (customerScreenStateDropDown.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Must enter a State/Province from the dropdown menu to create customer record");
                alert.showAndWait();

            } else {

                int customersID = Integer.parseInt(customerScreenID.getText());
                String customersName = customerScreenName.getText();
                String customersAddress = customerScreenAddress.getText();
                String customersPostalCode = customerScreenPostalCode.getText();
                String customersPhoneNumber = customerScreenPhoneNumber.getText();
                String customersCountryData = customerScreenStateDropDown.getValue().toString();
                String customersDivisionID = customerScreenCountryDropDown.getValue().toString();

                int index = Customers.getAllCustomers().indexOf(selectedCustomer);

                Customers addNewCustomer = new Customers(customersID, customersName, customersAddress, customersPostalCode, customersPhoneNumber, customersDivisionID, customersCountryData);

                Customers.updateCustomers(index, addNewCustomer);

                Customers.deleteCustomers(selectedCustomer);

                Customers.updateDataBaseCustomer(customersID, customersName, customersAddress, customersPostalCode, customersPhoneNumber, customersCountryData);

                Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 775, 400);
                stage.setTitle("Customer Records");
                stage.setScene(scene);
                stage.show();

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    /**
     * Method for on action event for onCustomerScreenBackButton
     * Loads the CustomerScreen scene upon pressing the back button
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomerScreenBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Initializes the CustomerUpdateScreen scene
     * Populates the text fields, combo boxes, dropdowns from the database, and converts country codes
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectedCustomer = CustomerScreenController.getCustomerToModify();

        customerScreenID.setText(String.valueOf(selectedCustomer.getCustomersID()));
        customerScreenName.setText(selectedCustomer.getCustomersName());
        customerScreenAddress.setText(selectedCustomer.getCustomersAddress());
        customerScreenPostalCode.setText(selectedCustomer.getCustomersPostalCode());
        customerScreenPhoneNumber.setText(selectedCustomer.getCustomersPhoneNumber());
        customerScreenStateDropDown.setValue(String.valueOf(selectedCustomer.getCustomersCountryData()));
        customerScreenCountryDropDown.setValue(String.valueOf(selectedCustomer.getCustomersDivisionID()));

        ObservableList<String> countryList = FXCollections.observableArrayList();

        ObservableList<Countries> countries = Countries.getAllCountries();

        if (countries != null) {

            for (Countries country : countries) {

                countryList.add(country.getCountries());

            }
        }

        customerScreenCountryDropDown.setItems(countryList);

        String q = customerScreenCountryDropDown.getValue().toString();

        if (q.equals("1") || q.equals("U.S")) {

            q = "1";

        } else if (q.equals("2") || q.equals("UK")) {

            q = "2";

        } else {

            q = "3";

        }

        ObservableList<String> firstLevelDivisionsList = FXCollections.observableArrayList();

        ObservableList<FirstLevelDivisions> filteredDivisions = lookupDivisions(q);

        if (filteredDivisions != null) {

            for (FirstLevelDivisions division : filteredDivisions) {

                firstLevelDivisionsList.add(division.getDivisions());

            }
        }

        customerScreenStateDropDown.setItems(firstLevelDivisionsList);

    }
}