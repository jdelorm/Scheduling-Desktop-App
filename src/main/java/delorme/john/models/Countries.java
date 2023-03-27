package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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







    private static ObservableList<Countries> allCountriesID = FXCollections.observableArrayList();

    public static ObservableList<Countries> getAllCountriesID() {

        return allCountriesID;

    }

    public static void setAllCountriesID(ObservableList<Countries> allCountriesID) {

        Countries.allCountriesID = allCountriesID;

    }

    public static void addCountriesID(Countries newCountriesID) {

        allCountriesID.add(newCountriesID);

    }


}
