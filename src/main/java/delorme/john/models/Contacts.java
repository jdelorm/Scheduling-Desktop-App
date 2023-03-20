package delorme.john.models;

public class Contacts {

    public int contactsID;
    public String contactsName;
    public String contactsEmail;

    public Contacts(int contactsID, String contactsName, String contactsEmail) {

        this.contactsID = contactsID;
        this.contactsName = contactsName;
        this.contactsEmail = contactsEmail;

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
}
