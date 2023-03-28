package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointments {

    private ObservableList<Customers> associatedCustomers = FXCollections.observableArrayList();
    private int appointmentsID;
    private String appointmentsTitle;
    private String appointmentsDescription;
    private String appointmentsLocation;
    private String appointmentsType;
    private LocalDate appointmentStartDate;
    private LocalDateTime appointmentsStartTime;
    private LocalDate appointmentEndDate;
    private LocalDateTime appointmentsEndTime;
    public int customersID;
    public int usersID;
    public String contactsID;

    public Appointments(int appointmentsID, String appointmentsTitle, String appointmentsDescription, String appointmentsLocation, String appointmentsType, LocalDateTime appointmentsStartTime, LocalDateTime appointmentsEndTime, int customersID, int usersID, String contactsID) {

        String contactName = contactsID;

        if (contactsID.equals("1") || contactsID.equals("Anita Costa")) {

            contactName = "Anita Costa";

        } else if (contactsID.equals("2") || contactsID.equals("Daniel Garcia")) {

            contactName = "Daniel Garcia";

        } else {

            contactName = "Li Lee";

        }

        this.appointmentsID = appointmentsID;
        this.appointmentsTitle = appointmentsTitle;
        this.appointmentsDescription = appointmentsDescription;
        this.appointmentsLocation = appointmentsLocation;
        this.appointmentsType = appointmentsType;
        this.appointmentsStartTime = appointmentsStartTime;
        this.appointmentsEndTime = appointmentsEndTime;
        this.customersID = customersID;
        this.usersID = usersID;
        this.contactsID = contactName;

    }

    public static ObservableList<Appointments> getAllDataBaseAppointments() throws SQLException {

        ObservableList<Appointments> appointmentsListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from appointments";

        PreparedStatement preparedStatementAppointment = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementAppointment.executeQuery();

        while (results.next()) {

            int appointmentsID = results.getInt("Appointment_ID");
            String appointmentsTitle = results.getString("Title");
            String appointmentsDescription = results.getString("Description");
            String appointmentsLocation = results.getString("Location");
            String appointmentsType = results.getString("Type");
            LocalDateTime appointmentsStartTime = results.getTimestamp("Start").toLocalDateTime();
            LocalDateTime appointmentsEndTime = results.getTimestamp("End").toLocalDateTime();
            int customersID = results.getInt("Customer_ID");
            int usersID = results.getInt("User_ID");
            String contactsID = results.getString("Contact_ID");

            Appointments newAppointment = new Appointments(appointmentsID, appointmentsTitle, appointmentsDescription, appointmentsLocation, appointmentsType, appointmentsStartTime, appointmentsEndTime, customersID, usersID, contactsID);

            Appointments.addAppointments(newAppointment);

        }

        return appointmentsListQuery;

    }

    private static int AppointmentID = 3;

    public static int getNewAppointmentID() {

        return AppointmentID++;

    }

    public int getAppointmentsID() {

        return appointmentsID;

    }

    public String getAppointmentsTitle() {

        return appointmentsTitle;

    }

    public String getAppointmentsDescription() {

        return appointmentsDescription;

    }

    public String getAppointmentsLocation() {

        return appointmentsLocation;

    }

    public String getAppointmentsType() {

        return appointmentsType;

    }

    public LocalDate getAppointmentStartDate() {

        return appointmentStartDate;

    }

    public LocalDateTime getAppointmentsStartTime() {

        return appointmentsStartTime;

    }

    public LocalDate getAppointmentEndDate() {

        return appointmentEndDate;

    }

    public LocalDateTime getAppointmentsEndTime() {

        return appointmentsEndTime;

    }

    public int getCustomersID () {


        return customersID;

    }

    public int getUsersID() {

        return usersID;

    }

    public String getContactsID() {

        return contactsID;

    }

    public void setAppointmentsID(int appointmentsID) {

        this.appointmentsID = appointmentsID;

    }

    public void setAppointmentsTitle(String appointmentsTitle) {

        this.appointmentsTitle = appointmentsTitle;

    }

    public void setAppointmentsDescription(String appointmentsDescription) {

        this.appointmentsDescription = appointmentsDescription;

    }

    public void setAppointmentsLocation(String appointmentsLocation) {

        this.appointmentsLocation = appointmentsLocation;

    }

    public void setAppointmentsType(String appointmentsType) {

        this.appointmentsType = appointmentsType;

    }

    public void setAppointmentStartDate(LocalDate appointmentStartDate) {

        this.appointmentStartDate = appointmentStartDate;

    }

    public void setAppointmentsStartTime(LocalDateTime appointmentsStartTime) {

        this.appointmentsStartTime = appointmentsStartTime;

    }

    public void setAppointmentEndDate(LocalDate appointmentEndDate) {

        this.appointmentEndDate = appointmentEndDate;

    }

    public void setAppointmentsEndTime(LocalDateTime appointmentsEndTime) {

        this.appointmentsEndTime = appointmentsEndTime;

    }

    public void setCustomersID(int customersID) {

        this.customersID = customersID;

    }

    public void setUsersID(int usersID) {

        this.usersID = usersID;

    }

    public void setContactsID(String contactsID) {

        this.contactsID = contactsID;

    }

    public static boolean deleteAppointments(Appointments selectedAppointments) {

        if (allAppointments.contains(selectedAppointments)) {

            allAppointments.remove(selectedAppointments);

            return true;

        } else {

            return false;

        }
    }

    public static void updateAppointments(int index, Appointments selectedAppointments) {

        allAppointments.set(index, selectedAppointments);

    }

    private static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();

    public static ObservableList<Appointments> getAllAppointments() {

        return allAppointments;

    }

    public static void setAllAppointments(ObservableList<Appointments> allAppointments) {

        Appointments.allAppointments = allAppointments;

    }

    public static void addAppointments(Appointments newAppointments) {

        allAppointments.add(newAppointments);

    }

    public void addAssociatedCustomers(Customers part) {

        associatedCustomers.add(part);

    }

    public boolean deleteAssociatedCustomers(Customers deleteCustomer) {

        return associatedCustomers.remove(deleteCustomer);

    }

    public ObservableList<Customers> getAllAssociatedCustomers() {

        return associatedCustomers;

    }
}
