package delorme.john.models;

import delorme.john.helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author John DeLorme
 * Countries class that contains the setters, getters, and
 * country data pulled from the database and stored in lists
 */

public class Countries {

    private int countriesID;
    private String countries;

    public Countries (int countriesID, String countries) {

        this.countriesID = countriesID;
        this.countries = countries;

    }

    /**
     * Method that pulls country data from database and stores it in a list
     * @return
     * @throws SQLException
     */

    public static ObservableList<Countries> getAllDataBaseCountries() throws SQLException {

        ObservableList<Countries> countriesListQuery = FXCollections.observableArrayList();

        String sql = "SELECT Country_ID, Country from countries";

        PreparedStatement preparedStatementCountry = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementCountry.executeQuery();

        while (results.next()) {

            int countryID = results.getInt("Country_ID");
            String countryName = results.getString("Country");

            Countries newCountry = new Countries(countryID, countryName);

            Countries.addCountries(newCountry);

        }

        return countriesListQuery;

    }

    /**
     * Getter method for getCountriesID
     * @return
     */

    public int getCountriesID() {

        return countriesID;

    }

    /**
     * Getter method for getCountries
     * @return
     */

    public String getCountries() {

        return countries;

    }

    /**
     * Setter method for setCountriesID
     * @param countriesID
     */

    public void setCountriesID(int countriesID) {

        this.countriesID = countriesID;

    }

    /**
     * Setter method for setCountries
     * @param countries
     */

    public void setCountries(String countries) {

        this.countries = countries;

    }

    /**
     * Method to delete countries
     * @param selectedCountries
     * @return
     */

    public static boolean deleteCountries(Countries selectedCountries) {

        if (allCountries.contains(selectedCountries)) {

            allCountries.remove(selectedCountries);

            return true;

        } else {

            return false;

        }
    }

    /**
     * Method to update countries
     * @param index
     * @param selectedCountries
     */

    public static void updateCountries(int index, Countries selectedCountries) {

        allCountries.set(index, selectedCountries);

    }

    private static ObservableList<Countries> allCountries = FXCollections.observableArrayList();

    /**
     * Getter method for getAllCountries
     * @return
     */

    public static ObservableList<Countries> getAllCountries() {

        return allCountries;

    }

    /**
     * Setter method for setAllCountries
     * @param allCountries
     */

    public static void setAllCountries(ObservableList<Countries> allCountries) {

        Countries.allCountries = allCountries;

    }

    /**
     * Method to add countries
     * @param newCountries
     */

    public static void addCountries(Countries newCountries) {

        allCountries.add(newCountries);

    }

    private static ObservableList<Countries> allCountriesID = FXCollections.observableArrayList();

    /**
     * Getter method for getAllCountriesID
     * @return
     */

    public static ObservableList<Countries> getAllCountriesID() {

        return allCountriesID;

    }

    /**
     * Setter method for setAllCountriesID
     * @param allCountriesID
     */

    public static void setAllCountriesID(ObservableList<Countries> allCountriesID) {

        Countries.allCountriesID = allCountriesID;

    }

    /**
     * Method to add countries ID
     * @param newCountriesID
     */

    public static void addCountriesID(Countries newCountriesID) {

        allCountriesID.add(newCountriesID);

    }
}