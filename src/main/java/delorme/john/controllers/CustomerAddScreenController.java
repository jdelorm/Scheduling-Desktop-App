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
import java.util.ResourceBundle;

import static delorme.john.models.FirstLevelDivisions.lookupProduct;

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

        ObservableList<FirstLevelDivisions> searchedParts = lookupProduct(q);

        if (searchedParts != null) {

            for (FirstLevelDivisions division : searchedParts) {

                firstLevelDivisionsList.add(division.getDivisions());

            }
        }

        customerScreenStateDropDown.setItems(firstLevelDivisionsList);

    }

    public void onCustomerScreenStateDropDown(ActionEvent actionEvent) {
    }

    public void onCustomerScreenAddButton(ActionEvent actionEvent) {

        if (customerScreenCountryDropDown.getValue() == null) {

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

            try {

                int customersID = Customers.getNewCustomerID();
                String customersName = customerScreenName.getText();
                String customersAddress = customerScreenAddress.getText();
                String customersPostalCode = customerScreenPostalCode.getText();
                String customersPhoneNumber = customerScreenPhoneNumber.getText();
                String customersCountryData = customerScreenStateDropDown.getValue().toString();
                String customersDivisionID = customerScreenCountryDropDown.getValue().toString();

                if (customersName.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Name field should not be empty");
                    alert.showAndWait();

                } else if (customersAddress.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Address field should not be empty");
                    alert.showAndWait();

                } else if (customersPostalCode.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Postal Code field should not be empty");
                    alert.showAndWait();

                } else if (customersPhoneNumber.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Phone Number field should not be empty");
                    alert.showAndWait();

                } else {

                    Customers addNewCustomer = new Customers(customersID, customersName, customersAddress, customersPostalCode, customersPhoneNumber, customersDivisionID, customersCountryData);

                    Customers.addCustomers(addNewCustomer);

                    Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root, 775, 400);
                    stage.setTitle("Customer Records");
                    stage.setScene(scene);
                    stage.show();

                }

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }
    }

    public void onCustomerScreenBackButton (ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 775, 400);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();

    }

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
