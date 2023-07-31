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
 * This class controls the CustomerAddScreen Scene
 */

public class CustomerAddScreenController implements Initializable {
    public Button customerScreenBackButton;
    public Button customerScreenAddButton;
    public ComboBox customerScreenCountryDropDown;
    public ComboBox customerScreenStateDropDown;
    public TextField customerScreenPhoneNumber;
    public TextField customerScreenPostalCode;
    public TextField customerScreenAddress;
    public TextField customerScreenName;
    public TextField customerScreenID;

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
     * Method for on action event onCustomerScreenAddress
     * @param actionEvent
     */

    public void onCustomerScreenAddress(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event onCustomerScreenPostalCode
     * @param actionEvent
     */

    public void onCustomerScreenPostalCode(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event onCustomerScreenPhoneNumber
     * @param actionEvent
     */

    public void onCustomerScreenPhoneNumber(ActionEvent actionEvent) {
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
     * Method for on action event for onCustomerScreenStateDropDown
     * @param actionEvent
     */

    public void onCustomerScreenStateDropDown(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onCustomerScreenAddButton
     * Checks text fields for proper inputs, displays warnings if applicable,
     * adds customer to database, and loads the CustomerScreen scene upon completion
     * @param actionEvent
     */

    public void onCustomerScreenAddButton(ActionEvent actionEvent) {

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

                String customersName = customerScreenName.getText();
                String customersAddress = customerScreenAddress.getText();
                String customersPostalCode = customerScreenPostalCode.getText();
                String customersPhoneNumber = customerScreenPhoneNumber.getText();
                String customersCountryData = customerScreenStateDropDown.getValue().toString();
                String customersDivisionID = customerScreenCountryDropDown.getValue().toString();

                int customersID = Customers.getNewCustomerID();

                Customers addNewCustomer = new Customers(customersID, customersName, customersAddress, customersPostalCode, customersPhoneNumber, customersDivisionID, customersCountryData);

                Customers.addCustomers(addNewCustomer);

                Customers.addNewDataBaseCustomer(customersID, customersName, customersAddress, customersPostalCode, customersPhoneNumber, customersCountryData);

                Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 775, 400);
                stage.setTitle("Customer Records");
                stage.setScene(scene);
                stage.show();

            }

        } catch (IOException | SQLException e) {

            throw new RuntimeException(e);

        }
    }

    /**
     * Method for on action event for onCustomerScreenBackButton
     * Loads the CustomerScreen scene upon clicking the back button
     * @param actionEvent
     * @throws IOException
     */

    public void onCustomerScreenBackButton (ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Initializes the CustomerAddScreen scene
     * Populates the customerScreenCountryDropDown combo box
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        ObservableList<String> countryList = FXCollections.observableArrayList();

        ObservableList<Countries> countries = Countries.getAllCountries();

        if (countries != null) {

            for (Countries country : countries) {

                countryList.add(country.getCountries());

            }
        }

        customerScreenCountryDropDown.setItems(countryList);

    }
}