package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author John DeLorme
 * Contacts class that contains the setters, getters, and contact information
 * pulled from the database and stores them in lists
 */

public class Contacts {

    public int contactsID;
    public String contactsName;
    public String contactsEmail;

    public Contacts(int contactsID, String contactsName, String contactsEmail) {

        this.contactsID = contactsID;
        this.contactsName = contactsName;
        this.contactsEmail = contactsEmail;

    }

    /**
     * Method that pulls contact information from database and stores them in lists
     * @return
     * @throws SQLException
     */

    public static ObservableList<Contacts> getAllDataBaseContacts() throws SQLException {

        ObservableList<Contacts> contactsListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from contacts";

        PreparedStatement preparedStatementContact = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementContact.executeQuery();

        while (results.next()) {

            int contactID = results.getInt("Contact_ID");
            String contactName = results.getString("Contact_Name");
            String contactEmail = results.getString("Email");

            Contacts newContact = new Contacts(contactID, contactName, contactEmail);

            Contacts.addContacts(newContact);

        }

        return contactsListQuery;

    }

    private static int contactID = 1000;

    /**
     * Getter method for getNewContactID
     * @return
     */

    public static int getNewContactID() {

        return contactID++;

    }

    /**
     * Getter method for getContactsID
     * @return
     */

    public int getContactsID() {

        return contactsID;

    }

    /**
     * Getter method for getContactsName
     * @return
     */

    public String getContactsName() {

        return contactsName;

    }

    /**
     * Getter method for getContactsEmail
     * @return
     */

    public String getContactsEmail() {

        return contactsEmail;

    }

    /**
     * Setter method for setContactsID
     * @param contactsID
     */

    public void setContactsID(int contactsID) {

        this.contactsID = contactsID;

    }

    /**
     * Setter method for setContactsName
     * @param contactsName
     */

    public void setContactsName(String contactsName) {

        this.contactsName = contactsName;

    }

    /**
     * Setter method for setContactsEmail
     * @param contactsName
     */

    public void setContactsEmail(String contactsName) {

        this.contactsEmail = contactsEmail;

    }

    /**
     * Method to delete contacts
     * @param selectedContacts
     * @return
     */

    public static boolean deleteContacts(Contacts selectedContacts) {

        if (allContacts.contains(selectedContacts)) {

            allContacts.remove(selectedContacts);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method to update contacts
     * @param index
     * @param selectedContacts
     */

    public static void updateContacts(int index, Contacts selectedContacts) {

        allContacts.set(index, selectedContacts);

    }

    private static ObservableList<Contacts> allContacts = FXCollections.observableArrayList();

    /**
     * Getter method for getAllContacts
     * @return
     */

    public static ObservableList<Contacts> getAllContacts() {

        return allContacts;

    }

    /**
     * Setter method for setAllContacts
     * @param allContacts
     */

    public static void setAllContacts(ObservableList<Contacts> allContacts) {

        Contacts.allContacts = allContacts;

    }

    /**
     * Method to add contacts
     * @param newContacts
     */

    public static void addContacts(Contacts newContacts) {

        allContacts.add(newContacts);

    }
}