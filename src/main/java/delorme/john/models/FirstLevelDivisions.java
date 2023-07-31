package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * @author John DeLorme
 * FirstLevelDiviions class that contains getters, setters, and info pulled from the database
 * and stored in a list
 */

public class FirstLevelDivisions {

    private int divisionsID;
    private String divisions;
    public String countriesID;

    public FirstLevelDivisions(int divisionsID, String divisions, String countriesID) {

        this.divisionsID = divisionsID;
        this.divisions = divisions;
        this.countriesID = countriesID;

    }

    /**
     * Method that pulls first level divisions info from database and stores it in a list
     *
     * @return
     * @throws SQLException
     */

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

    /**
     * Getter method for getDivisionsID
     *
     * @return
     */

    public int getDivisionsID() {

        return divisionsID;

    }

    /**
     * Getter method for getDivisions
     *
     * @return
     */

    public String getDivisions() {

        return divisions;

    }

    /**
     * Getter method for getCountriesID
     *
     * @return
     */

    public String getCountriesID() {

        return countriesID;
    }

    /**
     * Setter method for setDivisionsID
     *
     * @param divisionsID
     */

    public void setDivisionsID(int divisionsID) {

        this.divisionsID = divisionsID;

    }

    /**
     * Setter method for setDivisions
     *
     * @param divisions
     */

    public void setDivisions(String divisions) {

        this.divisions = divisions;

    }

    /**
     * Setter method for setCountriesID
     *
     * @param countriesID
     */

    public void setCountriesID(String countriesID) {

        this.countriesID = countriesID;

    }

    /**
     * Method to delete a first level division
     *
     * @param selectedFirstLevelDivisions
     * @return
     */

    public static boolean deleteFirstLevelDivisions(FirstLevelDivisions selectedFirstLevelDivisions) {

        if (allFirstLevelDivisions.contains(selectedFirstLevelDivisions)) {

            allFirstLevelDivisions.remove(selectedFirstLevelDivisions);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method to update a first level division
     *
     * @param index
     * @param selectedFirstLevelDivisions
     */

    public static void updateFirstLevelDivisions(int index, FirstLevelDivisions selectedFirstLevelDivisions) {

        allFirstLevelDivisions.set(index, selectedFirstLevelDivisions);

    }

    private static ObservableList<FirstLevelDivisions> allFirstLevelDivisions = FXCollections.observableArrayList();

    /**
     * Getter method for allFirstLevelDisions
     *
     * @return
     */

    public static ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {

        return allFirstLevelDivisions;

    }

    /**
     * Setter method for setAllFirstLevelDivisions
     *
     * @param allFirstLevelDivisions
     */

    public static void setAllFirstLevelDivisions(ObservableList<FirstLevelDivisions> allFirstLevelDivisions) {

        FirstLevelDivisions.allFirstLevelDivisions = allFirstLevelDivisions;

    }

    /**
     * Method to add a first level division
     *
     * @param newFirstLevelDivisions
     */

    public static void addFirstLevelDivisions(FirstLevelDivisions newFirstLevelDivisions) {

        allFirstLevelDivisions.add(newFirstLevelDivisions);

    }

    /**
     * Method to filter list of first level divisions data by country ID
     *
     * @param divisionsToLookup
     * @return
     */

    public static ObservableList<FirstLevelDivisions> lookupDivisions(String divisionsToLookup) {

        ObservableList<FirstLevelDivisions> filteredDivisions = FXCollections.observableArrayList();

        for (delorme.john.models.FirstLevelDivisions firstLevelDivisions : allFirstLevelDivisions) {

            if (firstLevelDivisions.getCountriesID().contains(divisionsToLookup)) {

                filteredDivisions.add(firstLevelDivisions);

            }
        }

        return filteredDivisions;

    }

    /**
     * Method that takes the selected division name and converts it to its division ID number
     *
     * @param countryDataToLookup
     * @return
     */

    public static int lookupCountryData(String countryDataToLookup) {

        FirstLevelDivisions firstLevelDivisions = null;

        for (Iterator<FirstLevelDivisions> i = FirstLevelDivisions.getAllFirstLevelDivisions().iterator(); i.hasNext(); ) {

            firstLevelDivisions = i.next();

            if (firstLevelDivisions.getDivisions().equals(countryDataToLookup)) {

                return firstLevelDivisions.divisionsID;

            }
        }

        return firstLevelDivisions.divisionsID;

    }
}