package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPostalCode;
    private String customerPhoneNumber;
    private int customerDivisionID;
    private String divisionName;

    public Customers(int customerID, String customerName, String customerAddress, String customerPostalCode, String customerPhoneNumber, int customerDivisionID, String divisionName) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerDivisionID = customerDivisionID;
        this.divisionName = divisionName;

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

    public String getDivisionName() {

        return divisionName;

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

    public void setDivisionName(String divisionName) {

        this.divisionName = divisionName;

    }

    public void setCustomerDivisionID(int customerDivisionID) {

        this.customerDivisionID = customerDivisionID;

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
