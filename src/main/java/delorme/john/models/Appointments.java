package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;
import java.util.Iterator;

/**
 * @author John DeLorme
 * Appointments class that contains the setters, getters, arrayLists, populate data,
 * and various time check methods for appointments
 */

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

    /**
     * Method that pulls allDataBaseAppointments and stores them in a list
     * @return
     * @throws SQLException
     */

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

    /**
     * Initializes appointmentID variable
     */

    private static Integer AppointmentID = 0;

    /**
     * Getter method for getNewAppointmentID
     * Creates a unique appointmentID based on the current highest appointmentID
     * @return
     */

    public static Integer getNewAppointmentID() {

        Integer maxValue = Integer.MIN_VALUE;

        for (Iterator<Appointments> i = Appointments.getAllAppointments().iterator(); i.hasNext();) {

            Appointments appointment = i.next();

            if (appointment.getAppointmentsID() > (maxValue)) {

                maxValue = appointment.getAppointmentsID();

            }
        }

        return maxValue + 1;

    }

    /**
     * Getter method for getAppointmentsID
     * @return
     */

    public Integer getAppointmentsID() {

        return appointmentsID;

    }

    /**
     * Getter method for getAppointmentsTitle
     * @return
     */

    public String getAppointmentsTitle() {

        return appointmentsTitle;

    }

    /**
     * Getter method for getAppointmentsDescription
     * @return
     */

    public String getAppointmentsDescription() {

        return appointmentsDescription;

    }

    /**
     * Getter method for getAppontmentsLocation
     * @return
     */

    public String getAppointmentsLocation() {

        return appointmentsLocation;

    }

    /**
     * Getter method for getAppointmentsType
     * @return
     */

    public String getAppointmentsType() {

        return appointmentsType;

    }

    /**
     * Getter method for getAppointmentStartDate
     * @return
     */

    public LocalDate getAppointmentStartDate() {

        return appointmentStartDate;

    }

    /**
     * Getter method for getAppointmentsStartTime
     * @return
     */

    public LocalDateTime getAppointmentsStartTime() {

        return appointmentsStartTime;

    }

    /**
     * Getter Method for getAppointmentEndDate
     * @return
     */

    public LocalDate getAppointmentEndDate() {

        return appointmentEndDate;

    }

    /**
     * Getter method for getAppointmentsEndTime
     * @return
     */

    public LocalDateTime getAppointmentsEndTime() {

        return appointmentsEndTime;

    }

    /**
     * Getter method for getCustomersID
     * @return
     */

    public Integer getCustomersID () {


        return customersID;

    }

    /**
     * Getter method for getUsersID
     * @return
     */

    public Integer getUsersID() {

        return usersID;

    }

    /**
     * Getter method for getContactsID
     * @return
     */

    public String getContactsID() {

        return contactsID;

    }

    /**
     * Setter method for setAppointmentsID
     * @param appointmentsID
     */

    public void setAppointmentsID(int appointmentsID) {

        this.appointmentsID = appointmentsID;

    }

    /**
     * Setter method for setAppointmentsTitle
     * @param appointmentsTitle
     */

    public void setAppointmentsTitle(String appointmentsTitle) {

        this.appointmentsTitle = appointmentsTitle;

    }

    /**
     * Setter method for setAppointmentsDescription
     * @param appointmentsDescription
     */

    public void setAppointmentsDescription(String appointmentsDescription) {

        this.appointmentsDescription = appointmentsDescription;

    }

    /**
     * Setter method for setAppointmentsLocation
     * @param appointmentsLocation
     */

    public void setAppointmentsLocation(String appointmentsLocation) {

        this.appointmentsLocation = appointmentsLocation;

    }

    /**
     * Setter method for setAppointmentsType
     * @param appointmentsType
     */

    public void setAppointmentsType(String appointmentsType) {

        this.appointmentsType = appointmentsType;

    }

    /**
     * Setter method for setAppointmentStartDate
     * @param appointmentStartDate
     */

    public void setAppointmentStartDate(LocalDate appointmentStartDate) {

        this.appointmentStartDate = appointmentStartDate;

    }

    /**
     * Setter method for setAppointmentsStartTime
     * @param appointmentsStartTime
     */

    public void setAppointmentsStartTime(LocalDateTime appointmentsStartTime) {

        this.appointmentsStartTime = appointmentsStartTime;

    }

    /**
     * Setter method for setAppointmentEndDate
     * @param appointmentEndDate
     */

    public void setAppointmentEndDate(LocalDate appointmentEndDate) {

        this.appointmentEndDate = appointmentEndDate;

    }

    /**
     * Setter method for setAppointmentsEndTime
     * @param appointmentsEndTime
     */

    public void setAppointmentsEndTime(LocalDateTime appointmentsEndTime) {

        this.appointmentsEndTime = appointmentsEndTime;

    }

    /**
     * Setter method for setCustomersID
     * @param customersID
     */

    public void setCustomersID(int customersID) {

        this.customersID = customersID;

    }

    /**
     * Setter method for setUsersID
     * @param usersID
     */

    public void setUsersID(int usersID) {

        this.usersID = usersID;

    }

    /**
     * Setter method for setContactsID
     * @param contactsID
     */

    public void setContactsID(String contactsID) {

        this.contactsID = contactsID;

    }

    /**
     * Method to delete appointments
     * @param selectedAppointments
     * @return
     */

    public static boolean deleteAppointments(Appointments selectedAppointments) {

        if (allAppointments.contains(selectedAppointments)) {

            allAppointments.remove(selectedAppointments);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method to updateAppointments
     * @param index
     * @param selectedAppointments
     */

    public static void updateAppointments(int index, Appointments selectedAppointments) {

        allAppointments.set(index, selectedAppointments);

    }

    private static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();

    /**
     * Getter method for getAllAppointments
     * @return
     */

    public static ObservableList<Appointments> getAllAppointments() {

        return allAppointments;

    }

    /**
     * Setter method for setAllAppointments
     * @param allAppointments
     */

    public static void setAllAppointments(ObservableList<Appointments> allAppointments) {

        Appointments.allAppointments = allAppointments;

    }

    /**
     * Method to add an appointment
     * @param newAppointments
     */

    public static void addAppointments(Appointments newAppointments) {

        allAppointments.add(newAppointments);

    }

    /**
     * Method to populate timeDropDown combo box
     * @return
     */

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

    /**
     * Method to verify appointments are within business hours
     * @param localStart
     * @param localEnd
     * @return
     */

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

    /**
     * Method to verify there are no overlapping appointments
     * @param appointmentsStartTime
     * @param appointmentsEndTime
     * @return
     */

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

    /**
     * Method to populate monthDropDown combo box
     * @return
     */

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

    /**
     * Method that adds an appointment to the sql database
     *
     * @param selectedAppointmentID
     * @param selectedAppointmentTitle
     * @param selectedAppointmentDescription
     * @param selectedAppointmentLocation
     * @param selectedAppointmentType
     * @param selectedAppointmentStartTime
     * @param selectedAppointmentEndTime
     * @param selectedCustomersID
     * @param selectedUsersID
     * @param selectedContactsID
     * @throws SQLException
     */

    public static void addNewDataBaseAppointment(Integer selectedAppointmentID, String selectedAppointmentTitle, String selectedAppointmentDescription, String selectedAppointmentLocation, String selectedAppointmentType, LocalDateTime selectedAppointmentStartTime, LocalDateTime selectedAppointmentEndTime, Integer selectedCustomersID, Integer selectedUsersID, String selectedContactsID) throws SQLException {

        String addAppointmentStatement = "INSERT INTO appointments (Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatementAppointment = JDBC.getConnection().prepareStatement(addAppointmentStatement);

        preparedStatementAppointment.setInt(1, selectedAppointmentID);
        preparedStatementAppointment.setString(2, selectedAppointmentTitle);
        preparedStatementAppointment.setString(3, selectedAppointmentDescription);
        preparedStatementAppointment.setString(4, selectedAppointmentLocation);
        preparedStatementAppointment.setString(5, selectedAppointmentType);
        preparedStatementAppointment.setTimestamp(6, Timestamp.valueOf(selectedAppointmentStartTime));
        preparedStatementAppointment.setTimestamp(7, Timestamp.valueOf(selectedAppointmentEndTime));
        preparedStatementAppointment.setInt(8, selectedCustomersID);
        preparedStatementAppointment.setInt(9, selectedUsersID);
        preparedStatementAppointment.setInt(10, Integer.parseInt(selectedContactsID));

        preparedStatementAppointment.execute();

    }

    /**
     * Method that deletes appointments from the sql database
     *
     * @param selectedAppointmentID
     * @throws SQLException
     */

    public static void deleteDataBaseAppointment(Integer selectedAppointmentID) throws SQLException {

        String deleteAppointmentStatement = "DELETE from appointments WHERE Appointment_ID=?";

        PreparedStatement preparedStatementDeleteAppointment = JDBC.getConnection().prepareStatement(deleteAppointmentStatement);

        preparedStatementDeleteAppointment.setInt(1, selectedAppointmentID);

        preparedStatementDeleteAppointment.execute();

    }

    /**
     * Method that updates the sql database appointments
     *
     * @param selectedAppointmentID
     * @param selectedAppointmentTitle
     * @param selectedAppointmentDescription
     * @param selectedAppointmentLocation
     * @param selectedAppointmentType
     * @param selectedAppointmentStartTime
     * @param selectedAppointmentEndTime
     * @param selectedCustomersID
     * @param selectedUsersID
     * @param selectedContactsID
     * @throws SQLException
     */

    public static void updateDataBaseAppointment(Integer selectedAppointmentID, String selectedAppointmentTitle, String selectedAppointmentDescription, String selectedAppointmentLocation, String selectedAppointmentType, LocalDateTime selectedAppointmentStartTime, LocalDateTime selectedAppointmentEndTime, Integer selectedCustomersID, Integer selectedUsersID, String selectedContactsID) throws SQLException {

        String updateAppointmentStatement = "UPDATE appointments SET Title=?, Description=?, Location=?, Type=?, Start=?, End=?, Customer_ID=?, User_ID=?, Contact_ID=? WHERE Appointment_ID=?";

        PreparedStatement preparedStatementAppointment = JDBC.getConnection().prepareStatement(updateAppointmentStatement);

        preparedStatementAppointment.setString(1, selectedAppointmentTitle);
        preparedStatementAppointment.setString(2, selectedAppointmentDescription);
        preparedStatementAppointment.setString(3, selectedAppointmentLocation);
        preparedStatementAppointment.setString(4, selectedAppointmentType);
        preparedStatementAppointment.setTimestamp(5, Timestamp.valueOf(selectedAppointmentStartTime));
        preparedStatementAppointment.setTimestamp(6, Timestamp.valueOf(selectedAppointmentEndTime));
        preparedStatementAppointment.setInt(7, selectedCustomersID);
        preparedStatementAppointment.setInt(8, selectedUsersID);
        preparedStatementAppointment.setInt(9, Integer.parseInt(selectedContactsID));
        preparedStatementAppointment.setInt(10, selectedAppointmentID);

        preparedStatementAppointment.execute();

    }
}