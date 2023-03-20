package delorme.john.models;

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

    public Appointments(int appointmentID, String appointmentTitle, String appointmentDescription, String appointmentLocation, String appointmentType, LocalDate appointmentStartDate, LocalDateTime appointmentStartTime, LocalDate appointmentEndDate, LocalDateTime appointmentEndTime, int customersID, int usersID, int contactsID) {

        this.appointmentID = appointmentID;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndDate = appointmentEndDate;
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
}
