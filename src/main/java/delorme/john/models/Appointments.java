package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.spi.DateFormatProvider;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Appointments {

    private Integer appointmentsID;
    private String appointmentsTitle;
    private String appointmentsDescription;
    private String appointmentsLocation;
    private String appointmentsType;
    private LocalDate appointmentStartDate;
    private LocalDateTime appointmentsStartTime;
    private LocalDate appointmentEndDate;
    private LocalDateTime appointmentsEndTime;
    public Integer customersID;
    public Integer usersID;
    public String contactsID;

    public Appointments(int appointmentsID, String appointmentsTitle, String appointmentsDescription, String appointmentsLocation, String appointmentsType, LocalDateTime appointmentsStartTime, LocalDateTime appointmentsEndTime, int customersID, int usersID, String contactsID) {

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

    private static Integer AppointmentID = 3;

    public static Integer getNewAppointmentID() {

        return AppointmentID++;

    }

    public Integer getAppointmentsID() {

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

    public Integer getCustomersID () {


        return customersID;

    }

    public Integer getUsersID() {

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

    public static ObservableList timeDropDownPopulate() {

        ObservableList<String> appointmentsTimesList = FXCollections.observableArrayList();

        LocalTime startTimes = LocalTime.of(0, 0);

        LocalTime endTimes = LocalTime.of(23, 45);

        appointmentsTimesList.add(startTimes.toString());

        while (startTimes.isBefore(endTimes)) {

            startTimes = startTimes.plusMinutes(15);

            appointmentsTimesList.add(startTimes.toString());

        }

        return appointmentsTimesList;
    }

    public static boolean businessTimeAppointmentsVerification(LocalDateTime localStart, LocalDateTime localEnd) {

        boolean appointmentCheck = false;

        ZoneId localTime = ZoneId.systemDefault();
        ZoneId localDate = ZoneId.systemDefault();

        ZonedDateTime zonedStartTime = localStart.atZone(localTime);
        ZonedDateTime zonedEndTime = localEnd.atZone(localTime);

        ZonedDateTime zonedStartDate = localStart.atZone(localDate);
        ZonedDateTime zonedEndDate = localEnd.atZone(localDate);

        ZonedDateTime zonedEasternStartTime = zonedStartTime.withZoneSameInstant(ZoneId.of("US/Eastern"));
        ZonedDateTime zonedEasternEndTime = zonedEndTime.withZoneSameInstant(ZoneId.of("US/Eastern"));

        ZonedDateTime zonedEasternStartDate = zonedStartDate.withZoneSameInstant(ZoneId.of("US/Eastern"));
        ZonedDateTime zonedEasternEndDate = zonedEndDate.withZoneSameInstant(ZoneId.of("US/Eastern"));

        LocalTime localStartTime = zonedEasternStartTime.toLocalTime();
        LocalTime localEndTime = zonedEasternEndTime.toLocalTime();

        LocalDate localStartDate = zonedEasternStartDate.toLocalDate();
        LocalDate localEndDate = zonedEasternEndDate.toLocalDate();


        if (localEndDate.isAfter(localStartDate) ||

                localEndDate.isEqual(localStartDate) &&

                localStartTime.isAfter(LocalTime.of(7, 59, 59)) &&

                localStartTime.isBefore(LocalTime.of(21, 45, 1)) &&

                localEndTime.isAfter(LocalTime.of(8, 14, 59)) &&

                localEndTime.isBefore(LocalTime.of(22, 0, 1)) &&

                localEndTime.isAfter(localStartTime)) {

            appointmentCheck = true;

        }

        return appointmentCheck;

    }

    public static boolean overlappingAppointmentVerification(LocalDateTime appointmentsStartTime, LocalDateTime appointmentsEndTime) {

        boolean appointmentCheck = false;

        ObservableList<Appointments> getAllAppointments = Appointments.getAllAppointments();

        for (Appointments appointmentsOverlapCheck : getAllAppointments) {

            LocalDateTime appointmentsOverlapCheckStart = appointmentsOverlapCheck.getAppointmentsStartTime();
            LocalDateTime appointmentsOverlapCheckEnd = appointmentsOverlapCheck.getAppointmentsEndTime();

            if (appointmentsOverlapCheckStart.equals(appointmentsEndTime) &&

                    appointmentsOverlapCheckEnd.isAfter(appointmentsOverlapCheckStart) &&

                    appointmentsOverlapCheckEnd.isAfter(appointmentsStartTime)) {

                return true;

            } else if (appointmentsOverlapCheckEnd.equals(appointmentsStartTime) &&

                    appointmentsOverlapCheckStart.isBefore(appointmentsOverlapCheckEnd) &&

                    appointmentsOverlapCheckStart.isBefore(appointmentsEndTime)) {

                return true;

            } else if ((appointmentsOverlapCheckStart.isBefore(appointmentsStartTime)) &&

                    (appointmentsOverlapCheckEnd.isAfter(appointmentsEndTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isBefore(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckStart.isAfter(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckEnd.isBefore(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckEnd.isAfter(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isEqual(appointmentsStartTime)) &&

                    (appointmentsOverlapCheckEnd.isAfter(appointmentsEndTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isEqual(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckStart.isAfter(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckEnd.isEqual(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckEnd.isAfter(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isBefore(appointmentsStartTime)) &&

                    (appointmentsOverlapCheckEnd.isEqual(appointmentsEndTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isBefore(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckStart.isEqual(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckEnd.isBefore(appointmentsEndTime)) &&

                    (appointmentsOverlapCheckEnd.isEqual(appointmentsStartTime))) {

                return false;

            } else if ((appointmentsOverlapCheckStart.isEqual(appointmentsStartTime)) &&

                    (appointmentsOverlapCheckEnd.isEqual(appointmentsEndTime))) {

                return false;

            } else {

                appointmentCheck = true;

            }
        }

        return appointmentCheck;

    }

    public static ObservableList monthDropDownPopulate() {

        ObservableList<String> monthEnumNameList = FXCollections.observableArrayList();

        monthEnumNameList.add("January");
        monthEnumNameList.add("February");
        monthEnumNameList.add("March");
        monthEnumNameList.add("April");
        monthEnumNameList.add("May");
        monthEnumNameList.add("June");
        monthEnumNameList.add("July");
        monthEnumNameList.add("August");
        monthEnumNameList.add("September");
        monthEnumNameList.add("October");
        monthEnumNameList.add("November");
        monthEnumNameList.add("December");

        return monthEnumNameList;

    }
}