package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointments {

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
    public int contactsID;

    public Appointments(int appointmentsID, String appointmentsTitle, String appointmentsDescription, String appointmentsLocation, String appointmentsType, /*LocalDate appointmentStartDate,*/ LocalDateTime appointmentsStartTime, /*LocalDate appointmentEndDate,*/ LocalDateTime appointmentsEndTime, int customersID, int usersID, int contactsID) {

        this.appointmentsID = appointmentsID;
        this.appointmentsTitle = appointmentsTitle;
        this.appointmentsDescription = appointmentsDescription;
        this.appointmentsLocation = appointmentsLocation;
        this.appointmentsType = appointmentsType;
        this.appointmentsStartTime = appointmentsStartTime;
        this.appointmentsEndTime = appointmentsEndTime;
        this.customersID = customersID;
        this.usersID = usersID;
        this.contactsID = contactsID;

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

    public int getContactsID() {

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

    public void setContactsID(int contactsID) {

        this.contactsID = contactsID;

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

}
