package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLevelDivisions {

    private int divisionsID;
    private String divisions;
    public String countriesID;

    public FirstLevelDivisions(int divisionsID, String divisions, String countriesID) {

        this.divisionsID = divisionsID;
        this.divisions = divisions;
        this.countriesID = countriesID;

    }

    public static ObservableList<FirstLevelDivisions> getAllDataBaseFirstLevelDivisions() throws SQLException {

        ObservableList<FirstLevelDivisions> firstLevelDivisionsListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from first_level_divisions";

        PreparedStatement preparedStatementDivision = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementDivision.executeQuery();

        while (results.next()) {

            int divisionID = results.getInt("Division_ID");
            String divisionName = results.getString("Division");
            String country_ID = results.getString("COUNTRY_ID");

            FirstLevelDivisions newFirstLevelDivision = new FirstLevelDivisions(divisionID, divisionName, country_ID);

            FirstLevelDivisions.addFirstLevelDivisions(newFirstLevelDivision);

        }

        return firstLevelDivisionsListQuery;

    }

    public int getDivisionsID() {

        return divisionsID;

    }

    public String getDivisions() {

        return divisions;

    }

    public String getCountriesID() {

        return countriesID;
    }

    public void setDivisionsID(int divisionsID) {

        this.divisionsID = divisionsID;

    }

    public void setDivisions(String divisions) {

        this.divisions = divisions;

    }

    public void setCountriesID(String countriesID) {

        this.countriesID = countriesID;

    }

    public static boolean deleteFirstLevelDivisions(FirstLevelDivisions selectedFirstLevelDivisions) {

        if (allFirstLevelDivisions.contains(selectedFirstLevelDivisions)) {

            allFirstLevelDivisions.remove(selectedFirstLevelDivisions);

            return true;

        } else {

            return false;

        }
    }

    public static void updateFirstLevelDivisions(int index, FirstLevelDivisions selectedFirstLevelDivisions) {

        allFirstLevelDivisions.set(index, selectedFirstLevelDivisions);

    }

    private static ObservableList<FirstLevelDivisions> allFirstLevelDivisions = FXCollections.observableArrayList();

    public static ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {

        return allFirstLevelDivisions;

    }

    public static void setAllFirstLevelDivisions(ObservableList<FirstLevelDivisions> allFirstLevelDivisions) {

        FirstLevelDivisions.allFirstLevelDivisions = allFirstLevelDivisions;

    }

    public static void addFirstLevelDivisions(FirstLevelDivisions newFirstLevelDivisions) {

        allFirstLevelDivisions.add(newFirstLevelDivisions);

    }

    public static ObservableList<FirstLevelDivisions> lookupDivisions(String divisionsToLookup) {

        ObservableList<FirstLevelDivisions> filteredDivisions = FXCollections.observableArrayList();

        for (delorme.john.models.FirstLevelDivisions firstLevelDivisions : allFirstLevelDivisions) {

            if (firstLevelDivisions.getCountriesID().contains(divisionsToLookup)) {

                filteredDivisions.add(firstLevelDivisions);

            }
        }

        return filteredDivisions;

    }
}
