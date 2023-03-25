package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacts {

    public int contactsID;
    public String contactsName;
    public String contactsEmail;

    public Contacts(int contactsID, String contactsName, String contactsEmail) {

        this.contactsID = contactsID;
        this.contactsName = contactsName;
        this.contactsEmail = contactsEmail;

    }

    private static int contactID = 1000;

    public static int getNewPartID() {

        return contactID++;

    }

    public int getContactsID() {

        return contactsID;

    }

    public String getContactsName() {

        return contactsName;

    }

    public String getContactsEmail() {

        return contactsEmail;

    }

    public void setContactsID(int contactsID) {

        this.contactsID = contactsID;

    }

    public void setContactsName(String contactsName) {

        this.contactsName = contactsName;

    }

    public void setContactsEmail(String contactsName) {

        this.contactsEmail = contactsEmail;

    }

    public static boolean deleteContacts(Contacts selectedContacts) {

        if (allContacts.contains(selectedContacts)) {

            allContacts.remove(selectedContacts);
            return true;

        } else {

            return false;

        }
    }

    public static void updateContacts(int index, Contacts selectedContacts) {

        allContacts.set(index, selectedContacts);

    }

    private static ObservableList<Contacts> allContacts = FXCollections.observableArrayList();

    public static ObservableList<Contacts> getAllContacts() {

        return allContacts;

    }

    public static void setAllContacts(ObservableList<Contacts> allContacts) {

        Contacts.allContacts = allContacts;

    }

    public static void addContacts(Contacts newContacts) {

        allContacts.add(newContacts);

    }
}
