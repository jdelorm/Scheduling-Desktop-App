package delorme.john.controllers;

import delorme.john.models.Appointments;
import delorme.john.models.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author John DeLorme
 * This class controls the MainScrene Scene
 */

public class MainScreenController implements Initializable {

    public Button loginButtonMain;
    public TextField userNameMain;
    public TextField passwordMain;
    public Label userLocationMain;
    public TextField zoneIdMain;
    public Label schedulingDesktopApplication;
    public Label password;
    public Label userName;

    /**
     * Method for on action event for onLoginButtonMain
     * Checks login test fields for proper input, displays warnings if applicable,
     * checks the username and password against the database, writes successful/unsuccessful login
     * attempts to a text file, checks for appointments within 15 minutes of successful login,
     * translates the login page and warnings to the default local, and then loads the
     * DirectoryScreen scene upon pressing the login button.
     * @param actionEvent
     * @throws IOException
     */

    public void onLoginButtonMain(ActionEvent actionEvent) throws IOException {

        try {

            ObservableList<Appointments> upcomingAppointmentCheck = Appointments.getAllAppointments();

            LocalDateTime plusFifteenMinutes = LocalDateTime.now().plusMinutes(15);
            LocalDateTime minusFifteenMinutes = LocalDateTime.now().minusMinutes(15);
            LocalDateTime timeCheck;
            LocalDateTime alertTime = null;

            String loginUserName = userNameMain.getText();
            String loginPassword = passwordMain.getText();

            Boolean appointmentCheck = false;
            Boolean accessGranted = false;
            Boolean accessDenied = false;

            FileWriter fileWriter = new FileWriter("login_activity.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int alertAppointmentsID = 0;
            int alertUserID = 0;

            ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.getDefault());
            //ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.FRENCH);

            if (loginUserName.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(rb.getString("Error"));
                alert.setContentText(rb.getString("Enter a Username"));
                alert.showAndWait();

            } else if (loginPassword.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(rb.getString("Error"));
                alert.setContentText(rb.getString("Enter a Password"));
                alert.showAndWait();

            } else {

                for (Iterator<Users> i = Users.getAllUsers().iterator(); i.hasNext(); ) {

                    Users users = i.next();

                    if (users.getUsersName().equals(loginUserName) && users.getUsersPassword().equals(loginPassword)) {

                        accessGranted = true;

                        break;

                    } else {

                        accessDenied = true;

                    }
                }
            }

            if (accessGranted == true) {

                Parent root = FXMLLoader.load(getClass().getResource("/delorme/john/DirectoryScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setTitle("Directory");
                stage.setScene(scene);
                stage.show();

                printWriter.print("Successful login by Username: " + loginUserName + "\n" + "Date and Time of login: " + Timestamp.valueOf(LocalDateTime.now()) + "\n" + "\n");
                printWriter.close();

                for (Appointments appointment : upcomingAppointmentCheck) {

                    timeCheck = appointment.getAppointmentsStartTime();

                    if ((timeCheck.isAfter(minusFifteenMinutes) || timeCheck.isEqual(minusFifteenMinutes)) && (timeCheck.isBefore(plusFifteenMinutes) || (timeCheck.isEqual(plusFifteenMinutes)))) {

                        alertAppointmentsID = appointment.getAppointmentsID();
                        alertUserID = appointment.getUsersID();
                        alertTime = timeCheck;
                        appointmentCheck = true;

                    }
                }

                if (appointmentCheck != false) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "There is an appointment within 15 minutes: " + "\n" + "Apt_ID: " + alertAppointmentsID + "\n" + "Apt_Start_Time: " + alertTime + "\n" + "Users_ID: " + alertUserID);
                    Optional<ButtonType> confirmation = alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "There are no appointments within 15 minutes");
                    Optional<ButtonType> confirmation = alert.showAndWait();

                }

            } else if (accessDenied == true) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(rb.getString("Error"));
                alert.setContentText(rb.getString("Password and/or Username incorrect"));
                alert.showAndWait();

                printWriter.print("Unsuccessful login attempt by Username: " + loginUserName + "\n" + "Date and Time of login attempt: " + Timestamp.valueOf(LocalDateTime.now()) + "\n" + "\n");
                printWriter.close();

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    /**
     * Method for on action event for onUserNameMain
     * @param actionEvent
     */

    public void onUserNameMain(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onPasswordMain
     * @param actionEvent
     */

    public void onPasswordMain(ActionEvent actionEvent) {
    }

    /**
     * Method for on action event for onZoneIdMain
     * @param actionEvent
     */

    public void onZoneIdMain(ActionEvent actionEvent) {
    }

    /**
     * Initializes the MainScreen scene
     * Checks default locale and changes language for labels and buttons based on locale
     * Sets and displays system zone id based on system settings
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        zoneIdMain.setText(String.valueOf(ZoneId.systemDefault()));

        try {

            ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.getDefault());
            //ResourceBundle rb = ResourceBundle.getBundle("Nat", Locale.FRENCH);

            loginButtonMain.setText(rb.getString("Login"));
            userLocationMain.setText(rb.getString("Operating System's Zone ID"));
            password.setText(rb.getString("Password"));
            userName.setText(rb.getString("Username"));
            schedulingDesktopApplication.setText(rb.getString("Scheduling Desktop Application"));

        } catch(MissingResourceException e) {

            System.out.println("Resource file missing: " + e);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }
}