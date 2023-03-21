package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers {

    private int customersID;
    private String customersName;
    private String customersAddress;
    private String customersPostalCode;
    private String customersPhoneNumber;
    private int customersDivisionID;
    private String customersCountryData;

    public Customers(int customersID, String customersName, String customersAddress, String customersPostalCode, String customersPhoneNumber, int customersDivisionID, String customersCountryData) {

        this.customersID = customersID;
        this.customersName = customersName;
        this.customersAddress = customersAddress;
        this.customersPostalCode = customersPostalCode;
        this.customersPhoneNumber = customersPhoneNumber;
        this.customersDivisionID = customersDivisionID;
        this.customersCountryData = customersCountryData;

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

    public Integer getCustomersDivisionID() {

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

    public void setCustomersDivisionID(int customersDivisionID) {

        this.customersDivisionID = customersDivisionID;

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
