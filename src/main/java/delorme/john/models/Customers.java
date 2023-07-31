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

/**
 * @author John DeLorme
 * Customers class that contains getters, setters, customer data pulled from
 * database and stored in a list, and various methods to manipulate the data
 */

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

    /**
     * Method that pulls customer info from database and stores it in a list
     *
     * @return
     * @throws SQLException
     */

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

    /**
     * Initializes customerID variable
     */

    private static Integer customerID = 0;

    /**
     * Getter method for getNewCustomersID
     * Creates a unique customerID based on the current highest customerID
     * @return
     */

    public static Integer getNewCustomerID() {

        Integer maxValue = Integer.MIN_VALUE;

        for (Iterator<Customers> i = Customers.getAllCustomers().iterator(); i.hasNext();) {

            Customers customers = i.next();

            if (customers.getCustomersID() > (maxValue)) {

                maxValue = customers.getCustomersID();

            }
        }

        return maxValue + 1;

    }

    /**
     * Getter method for getCustomersID
     *
     * @return
     */

    public Integer getCustomersID() {

        return customersID;

    }

    /**
     * Getter method for getCustomersName
     *
     * @return
     */

    public String getCustomersName() {

        return customersName;

    }

    /**
     * Getter method for getCustomersAddress
     *
     * @return
     */

    public String getCustomersAddress() {

        return customersAddress;

    }

    /***
     * Getter method for getCustomersPostalCode
     * @return
     */

    public String getCustomersPostalCode() {

        return customersPostalCode;

    }

    /**
     * Getter method for getCustomersPhoneNumber
     *
     * @return
     */

    public String getCustomersPhoneNumber() {

        return customersPhoneNumber;

    }

    /**
     * Getter method for getCustomersCountryData
     *
     * @return
     */

    public String getCustomersCountryData() {

        return customersCountryData;

    }

    /**
     * Getter method for getCustomersDivisionID
     *
     * @return
     */

    public String getCustomersDivisionID() {

        return customersDivisionID;

    }

    /**
     * Setter method for setCustomersID
     *
     * @param customersID
     */

    public void setCustomersID(int customersID) {

        this.customersID = customersID;

    }

    /**
     * Setter method for setCustomersName
     *
     * @param customersName
     */

    public void setCustomersName(String customersName) {

        this.customersName = customersName;

    }

    /**
     * Setter method for setCustomersAddress
     *
     * @param customersAddress
     */

    public void setCustomersAddress(String customersAddress) {

        this.customersAddress = customersAddress;

    }

    /**
     * Setter method for setCustomersPostalCode
     *
     * @param customersPostalCode
     */

    public void setCustomersPostalCode(String customersPostalCode) {

        this.customersPostalCode = customersPostalCode;

    }

    /**
     * Setter method for setCustomersPhoneNumber
     *
     * @param customersPhoneNumber
     */

    public void setCustomersPhoneNumber(String customersPhoneNumber) {

        this.customersPhoneNumber = customersPhoneNumber;

    }

    /**
     * Setter method for setCustomersCountryData
     *
     * @param customersCountryData
     */

    public void setCustomersCountryData(String customersCountryData) {

        this.customersCountryData = customersCountryData;

    }

    /**
     * Setter method for setCustomersDivisionID
     *
     * @param customersDivisionID
     */

    public void setCustomersDivisionID(String customersDivisionID) {

        this.customersDivisionID = customersDivisionID;

    }

    /**
     * Method for deleting a customer
     *
     * @param selectedCustomers
     * @return
     */

    public static boolean deleteCustomers(Customers selectedCustomers) {

        if (allCustomers.contains(selectedCustomers)) {

            allCustomers.remove(selectedCustomers);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method for deleting a appointment that is associated with a customer
     *
     * @param selectedCustomers
     */

    public static void deleteAssociatedAppointments(Customers selectedCustomers) throws SQLException {


        Integer selectedCustomersID = selectedCustomers.getCustomersID();

        Appointments appointment = null;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext(); ) {

            appointment = i.next();

            if (appointment.getCustomersID().equals(selectedCustomersID)) {

                i.remove();

                Appointments selectedAppointment = appointment;

                Appointments.deleteDataBaseAppointment(selectedAppointment.getAppointmentsID());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Appointment ID: " + selectedAppointment.getAppointmentsID() + " Type: " + selectedAppointment.getAppointmentsType() + " has been removed.");
                Optional<ButtonType> result = alert.showAndWait();

            }
        }
    }

    /**
     * Method to update a customer
     *
     * @param index
     * @param selectedCustomers
     */

    public static void updateCustomers(int index, Customers selectedCustomers) {

        allCustomers.set(index, selectedCustomers);

    }

    private static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();

    /**
     * Getter method for getAllCustomers
     *
     * @return
     */

    public static ObservableList<Customers> getAllCustomers() {

        return allCustomers;

    }

    /**
     * Setter method for setAllCustomers
     *
     * @param allCustomers
     */

    public static void setAllCustomers(ObservableList<Customers> allCustomers) {

        Customers.allCustomers = allCustomers;

    }

    /**
     * Method to add a customer
     *
     * @param newCustomers
     */

    public static void addCustomers(Customers newCustomers) {

        allCustomers.add(newCustomers);

    }

    /**
     * Method that adds the new customer to the sql database
     *
     * @param selectedCustomersID
     * @param selectedCustomersName
     * @param selectedCustomersAddress
     * @param selectedCustomersPostalCode
     * @param selectedCustomersPhoneNumber
     * @param selectedCustomerCountryData
     * @throws SQLException
     */

    public static void addNewDataBaseCustomer(Integer selectedCustomersID, String selectedCustomersName, String selectedCustomersAddress, String selectedCustomersPostalCode, String selectedCustomersPhoneNumber, String selectedCustomerCountryData) throws SQLException {

        int customerDatabaseCountryID = FirstLevelDivisions.lookupCountryData(selectedCustomerCountryData);

        String addCustomerStatement = "INSERT INTO customers (Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatementCustomer = JDBC.getConnection().prepareStatement(addCustomerStatement);

        preparedStatementCustomer.setString(1, String.valueOf(selectedCustomersID));
        preparedStatementCustomer.setString(2, String.valueOf(selectedCustomersName));
        preparedStatementCustomer.setString(3, String.valueOf(selectedCustomersAddress));
        preparedStatementCustomer.setString(4, String.valueOf(selectedCustomersPostalCode));
        preparedStatementCustomer.setString(5, String.valueOf(selectedCustomersPhoneNumber));
        preparedStatementCustomer.setInt(6, customerDatabaseCountryID);

        preparedStatementCustomer.execute();

    }

    /**
     * Method that deletes the selected customer from the sql database
     *
     * @param selectedCustomersID
     * @throws SQLException
     */

    public static void deleteDataBaseCustomer(Integer selectedCustomersID) throws SQLException {

        String deleteCustomerStatement = "DELETE from customers WHERE Customer_ID=?";

        PreparedStatement preparedStatementDeleteCustomer = JDBC.getConnection().prepareStatement(deleteCustomerStatement);

        preparedStatementDeleteCustomer.setInt(1, selectedCustomersID);

        preparedStatementDeleteCustomer.execute();

    }

    /**
     * Method that updates the selected customer in the sql database
     *
     * @param selectedCustomersID
     * @param selectedCustomersName
     * @param selectedCustomersAddress
     * @param selectedCustomersPostalCode
     * @param selectedCustomersPhoneNumber
     * @param selectedCustomerCountryData
     * @throws SQLException
     */

    public static void updateDataBaseCustomer(Integer selectedCustomersID, String selectedCustomersName, String selectedCustomersAddress, String selectedCustomersPostalCode, String selectedCustomersPhoneNumber, String selectedCustomerCountryData) throws SQLException {

        int customerDatabaseCountryID = FirstLevelDivisions.lookupCountryData(selectedCustomerCountryData);

        String updateCustomerStatement = "UPDATE customers SET Customer_Name=?, Address=?, Postal_Code=?, Phone=?, Division_ID=? WHERE Customer_ID=?";

        PreparedStatement preparedStatementCustomer = JDBC.getConnection().prepareStatement(updateCustomerStatement);

        preparedStatementCustomer.setString(1, String.valueOf(selectedCustomersName));
        preparedStatementCustomer.setString(2, String.valueOf(selectedCustomersAddress));
        preparedStatementCustomer.setString(3, String.valueOf(selectedCustomersPostalCode));
        preparedStatementCustomer.setString(4, String.valueOf(selectedCustomersPhoneNumber));
        preparedStatementCustomer.setInt(5, customerDatabaseCountryID);
        preparedStatementCustomer.setString(6, String.valueOf(selectedCustomersID));

        preparedStatementCustomer.execute();

    }
}