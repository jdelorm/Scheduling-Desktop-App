package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customers {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPostalCode;
    private String customerPhoneNumber;
    private String customerDivision;
    private String customerCountry;
    private int customerDivisionID;

    public Customers(int customerID, String customerName, String customerAddress, String customerPostalCode, String customerPhoneNumber, String customerDivision, String customerCountry, int customerDivisionID) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerDivision = customerDivision;
        this.customerCountry = customerCountry;
        this.customerDivisionID = customerDivisionID;

    }

    public Integer getCustomerID() {

        return customerID;

    }

    public String getCustomerName() {

        return customerName;

    }

    public String getCustomerAddress() {

        return customerAddress;

    }

    public String getCustomerPostalCode() {

        return customerPostalCode;

    }

    public String getCustomerPhoneNumber() {

        return customerPhoneNumber;

    }

    public String getCustomerDivision() {

        return customerDivision;

    }

    public String getCustomerCountry() {

        return customerCountry;

    }

    public Integer getCustomerDivisionID() {

        return customerDivisionID;

    }

    public void setCustomerID(int customerID) {

        this.customerID = customerID;

    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;

    }

    public void setCustomerAddress(String customerAddress) {

        this.customerAddress = customerAddress;

    }

    public void setCustomerPostalCode(String customerPostalCode) {

        this.customerPostalCode = customerPostalCode;

    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {

        this.customerPhoneNumber = customerPhoneNumber;

    }

    public void setCustomerDivision(String customerDivision) {

        this.customerDivision = customerDivision;

    }

    public void setCustomerCountry(String customerCountry) {

        this.customerCountry = customerCountry;

    }

    public void setCustomerDivisionID(int customerDivisionID) {

        this.customerDivisionID = customerDivisionID;

    }

    /*public static ObservableList<Customers> getAllCustomers(Connection connection) throws SQLException {

        String query = "SELECT customers.Customer_ID, customers.Customer_Name, customers.Address, customers.Postal_Code, customers.Phone, customers.Division_ID, first_level_divisions.Division from customers INNER JOIN  first_level_divisions ON customers.Division_ID = first_level_divisions.Division_ID";

        PreparedStatement ps = JDBC.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ObservableList<Customers> customersObservableList = FXCollections.observableArrayList();

        while (rs.next()) {
            int customerID = rs.getInt("Customer_ID");
            String customerName = rs.getString("Customer_Name");
            String customerAddress = rs.getString("Address");
            String customerPostalCode = rs.getString("Postal_Code");
            String customerPhone = rs.getString("Phone");
            int divisionID = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            Customers customer = new Customers(customerID, customerName, customerAddress, customerPostalCode, customerPhone, divisionID, divisionName);
            customersObservableList.add(customer);
        }
        return customersObservableList;
    }*/

}
