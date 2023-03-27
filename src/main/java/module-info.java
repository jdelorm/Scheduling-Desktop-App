module delorme.john {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires jdk.management.agent;


    opens delorme.john to javafx.fxml;
    exports delorme.john;
    exports delorme.john.controllers;
    opens delorme.john.controllers to javafx.fxml;

    opens delorme.john.models to javafx.fxml;
    exports delorme.john.models;


}