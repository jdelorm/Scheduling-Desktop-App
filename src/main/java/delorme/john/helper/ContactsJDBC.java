package delorme.john.helper;

import delorme.john.models.Appointments;
import delorme.john.models.Contacts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsJDBC {

    public static ObservableList<Contacts> getAllContacts() throws SQLException {

        ObservableList<Contacts> contactsListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from contacts";

        PreparedStatement preparedStatementContact = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementContact.executeQuery();

        while (results.next()) {

            int contactID = results.getInt("Contact_ID");
            String contactName = results.getString("Contact_Name");
            String contactEmail = results.getString("Email");

            Contacts newContact = new Contacts(contactID, contactName, contactEmail);

            //contactsListQuery.add(contact);

            Contacts.addContacts(newContact);

        }

        return contactsListQuery;

    }
}