package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FirstLevelDivisions {

    private int divisionsID;
    private String divisions;
    public int countriesID;

    public FirstLevelDivisions(int divisionsID, String divisions, int countriesID) {

        this.divisionsID = divisionsID;
        this.divisions = divisions;
        this.countriesID = countriesID;

    }

    public int getDivisionsID() {

        return divisionsID;

    }

    public String getDivisions() {

        return divisions;

    }

    public int getCountriesID() {

        return countriesID;
    }

    public void setDivisionsID(int divisionsID) {

        this.divisionsID = divisionsID;

    }

    public void setDivisions(String divisions) {

        this.divisions = divisions;

    }

    public void setCountriesID(int countriesID) {

        this.countriesID = countriesID;

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

}
