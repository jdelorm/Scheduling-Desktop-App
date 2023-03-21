package delorme.john.helper;

import delorme.john.models.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersJDBC {

    public static ObservableList<Customers> getAllCustomers() throws SQLException {

        ObservableList<Customers> customersListQuery = FXCollections.observableArrayList();

            String query = "SELECT customers.Customer_ID, customers.Customer_Name, customers.Address, customers.Postal_Code, customers.Phone, customers.Division_ID, first_level_divisions.Division from customers INNER JOIN  first_level_divisions ON customers.Division_ID = first_level_divisions.Division_ID";

            PreparedStatement preparedStatementCustomer = JDBC.getConnection().prepareStatement(query);

            ResultSet results = preparedStatementCustomer.executeQuery();

            while (results.next()) {

                int customerID = results.getInt("Customer_ID");
                String customerName = results.getString("Customer_Name");
                String customerAddress = results.getString("Address");
                String customerPostalCode = results.getString("Postal_Code");
                String customerPhone = results.getString("Phone");
                int divisionID = results.getInt("Division_ID");
                String divisionName = results.getString("Division");

                Customers customer = new Customers(customerID, customerName, customerAddress, customerPostalCode, customerPhone, divisionID, divisionName);

                customersListQuery.add(customer);

            }

            return customersListQuery;

    }
}
