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
}
