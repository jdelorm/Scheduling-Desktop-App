package delorme.john.helper;

import delorme.john.models.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppointmentsJDBC {

    public static ObservableList<Appointments> getAllAppointments() throws SQLException {

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
}
