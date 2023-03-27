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

            int appointmentID = results.getInt("Appointment_ID");
            String appointmentTitle = results.getString("Title");
            String appointmentDescription = results.getString("Description");
            String appointmentLocation = results.getString("Location");
            String appointmentType = results.getString("Type");
            LocalDateTime start = results.getTimestamp("Start").toLocalDateTime();
            LocalDateTime end = results.getTimestamp("End").toLocalDateTime();
            int customerID = results.getInt("Customer_ID");
            int userID = results.getInt("User_ID");
            int contactID = results.getInt("Contact_ID");

            Appointments newAppointment = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contactID);

            Appointments.addAppointments(newAppointment);

        }

        return appointmentsListQuery;

    }
}
