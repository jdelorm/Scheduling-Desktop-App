package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers {

    private int customersID;
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

    private static int customerID = 4;

    public static int getNewCustomerID() {

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
