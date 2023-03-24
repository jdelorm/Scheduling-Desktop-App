package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Countries {

    private int countriesID;
    private String countries;

    public Countries (int countriesID, String countries) {

        this.countriesID = countriesID;
        this.countries = countries;

    }

    public int getCountriesID() {

        return countriesID;

    }

    public String getCountries() {

        return countries;

    }

    public void setCountriesID(int countriesID) {

        this.countriesID = countriesID;

    }

    public void setCountries(String countries) {

        this.countries = countries;

    }

    public static boolean deleteCountries(Countries selectedCountries) {

        if (allCountries.contains(selectedCountries)) {

            allCountries.remove(selectedCountries);
            return true;

        } else {

            return false;

        }
    }

    public static void updateCountries(int index, Countries selectedCountries) {

        allCountries.set(index, selectedCountries);

    }

    private static ObservableList<Countries> allCountries = FXCollections.observableArrayList();

    public static ObservableList<Countries> getAllCountries() {

        return allCountries;

    }

    public static void setAllCountries(ObservableList<Countries> allCountries) {

        Countries.allCountries = allCountries;

    }

    public static void addCountries(Countries newCountries) {

        allCountries.add(newCountries);

    }
}
