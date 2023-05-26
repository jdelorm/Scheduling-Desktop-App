package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Customers {

    private Integer customersID;
    private String customersName;
    private String customersAddress;
    private String customersPostalCode;
    private String customersPhoneNumber;
    private String customersDivisionID;
    private String customersCountryData;

    public Customers(int customersID, String customersName, String customersAddress, String customersPostalCode, String customersPhoneNumber, String customersDivisionID, String customersCountryData) {

        String countryName = customersDivisionID;

        if (customersDivisionID.equals("1") || customersDivisionID.equals("U.S")) {

            countryName = "U.S";

        } else if (customersDivisionID.equals("2") || customersDivisionID.equals("UK")) {

            countryName = "UK";

        } else {

            countryName = "Canada";

        }

        this.customersID = customersID;
        this.customersName = customersName;
        this.customersAddress = customersAddress;
        this.customersPostalCode = customersPostalCode;
        this.customersPhoneNumber = customersPhoneNumber;
        this.customersDivisionID = countryName;
        this.customersCountryData = customersCountryData;

    }

    public static ObservableList<Customers> getAllDataBaseCustomers() throws SQLException {

        ObservableList<Customers> customersListQuery = FXCollections.observableArrayList();

        String query = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone," + "first_level_divisions.COUNTRY_ID, first_level_divisions.Division FROM customers, first_level_divisions WHERE customers.Division_ID = first_level_divisions.Division_ID ORDER BY Customer_ID";

        PreparedStatement preparedStatementCustomer = JDBC.getConnection().prepareStatement(query);

        ResultSet results = preparedStatementCustomer.executeQuery();

        while (results.next()) {

            int customerID = results.getInt("Customer_ID");
            String customerName = results.getString("Customer_Name");
            String customerAddress = results.getString("Address");
            String customerPostalCode = results.getString("Postal_Code");
            String customerPhone = results.getString("Phone");
            String divisionID = results.getString("Country_ID");
            String divisionName = results.getString("Division");

            Customers newCustomer = new Customers(customerID, customerName, customerAddress, customerPostalCode, customerPhone, divisionID, divisionName);

            Customers.addCustomers(newCustomer);

        }

        return customersListQuery;

    }

    private static Integer customerID = 4;

    public static Integer getNewCustomerID() {

        return customerID++;

    }

    public Integer getCustomersID() {

        return customersID;

    }

    public String getCustomersName() {

        return customersName;

    }

    public String getCustomersAddress() {

        return customersAddress;

    }

    public String getCustomersPostalCode() {

        return customersPostalCode;

    }

    public String getCustomersPhoneNumber() {

        return customersPhoneNumber;

    }

    public String getCustomersCountryData() {

        return customersCountryData;

    }

    public String getCustomersDivisionID() {

        return customersDivisionID;

    }

    public void setCustomersID(int customersID) {

        this.customersID = customersID;

    }

    public void setCustomersName(String customersName) {

        this.customersName = customersName;

    }

    public void setCustomersAddress(String customersAddress) {

        this.customersAddress = customersAddress;

    }

    public void setCustomersPostalCode(String customersPostalCode) {

        this.customersPostalCode = customersPostalCode;

    }

    public void setCustomersPhoneNumber(String customersPhoneNumber) {

        this.customersPhoneNumber = customersPhoneNumber;

    }

    public void setCustomersCountryData(String customersCountryData) {

        this.customersCountryData = customersCountryData;

    }

    public void setCustomersDivisionID(String customersDivisionID) {

        this.customersDivisionID = customersDivisionID;

    }

    public static boolean deleteCustomers(Customers selectedCustomers) {

        if (allCustomers.contains(selectedCustomers)) {

            allCustomers.remove(selectedCustomers);

            return true;

        } else {

            return false;

        }
    }

    public static void deleteAssociatedAppointments(Customers selectedCustomers) {


        Integer selectedCustomersID = selectedCustomers.getCustomersID();

        Appointments appointment = null;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext(); ) {

            appointment = i.next();

            if (appointment.getCustomersID().equals(selectedCustomersID)) {

                i.remove();

                Appointments selectedAppointment = appointment;

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Appointment ID: " + selectedAppointment.getAppointmentsID() + " Type: " + selectedAppointment.getAppointmentsType() + " has been removed.");
                Optional<ButtonType> result = alert.showAndWait();

            }
        }
    }

    public static void updateCustomers(int index, Customers selectedCustomers) {

        allCustomers.set(index, selectedCustomers);

    }

    private static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();

    public static ObservableList<Customers> getAllCustomers() {

        return allCustomers;

    }

    public static void setAllCustomers(ObservableList<Customers> allCustomers) {

        Customers.allCustomers = allCustomers;

    }

    public static void addCustomers(Customers newCustomers) {

        allCustomers.add(newCustomers);

    }
}
