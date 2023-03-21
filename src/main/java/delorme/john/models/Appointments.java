package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointments {

    private int appointmentID;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDate appointmentStartDate;
    private LocalDateTime appointmentStartTime;
    private LocalDate appointmentEndDate;
    private LocalDateTime appointmentEndTime;
    public int customersID;
    public int usersID;
    public int contactsID;

    public Appointments(int appointmentID, String appointmentTitle, String appointmentDescription, String appointmentLocation, String appointmentType, /*LocalDate appointmentStartDate,*/ LocalDateTime appointmentStartTime, /*LocalDate appointmentEndDate,*/ LocalDateTime appointmentEndTime, int customersID, int usersID, int contactsID) {

        this.appointmentID = appointmentID;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        //this.appointmentStartDate = appointmentStartDate;
        this.appointmentStartTime = appointmentStartTime;
        //this.appointmentEndDate = appointmentEndDate;
        this.appointmentEndTime = appointmentEndTime;
        this.customersID = customersID;
        this.usersID = usersID;
        this.contactsID = contactsID;

    }

    public int getAppointmentID() {

        return appointmentID;

    }

    public String getAppointmentTitle() {

        return appointmentTitle;

    }

    public String getAppointmentDescription() {

        return appointmentDescription;

    }

    public String getAppointmentLocation() {

        return appointmentLocation;

    }

    public String getAppointmentType() {

        return appointmentType;

    }

    public LocalDate getAppointmentStartDate() {

        return appointmentStartDate;

    }

    public LocalDateTime getAppointmentStartTime() {

        return appointmentStartTime;

    }

    public LocalDate getAppointmentEndDate() {

        return appointmentEndDate;

    }

    public LocalDateTime getAppointmentEndTime() {

        return appointmentEndTime;

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

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public void setAppointmentLocation(String appointmentLocation) {
        this.appointmentLocation = appointmentLocation;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setAppointmentStartDate(LocalDate appointmentStartDate) {
        this.appointmentStartDate = appointmentStartDate;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public void setAppointmentEndDate(LocalDate appointmentEndDate) {
        this.appointmentEndDate = appointmentEndDate;
    }

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
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

    public static void addAppointment(Appointments newAppointment) {

        allAppointments.add(newAppointment);
    }

}
