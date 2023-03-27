package delorme.john.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FirstLevelDivisions {

    private int divisionsID;
    private String divisions;
    public String countriesID;

    public FirstLevelDivisions(int divisionsID, String divisions, String countriesID) {

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

    public static ObservableList<FirstLevelDivisions> lookupProduct(String productName) {

        ObservableList<FirstLevelDivisions> productNameSearch = FXCollections.observableArrayList();

        for (delorme.john.models.FirstLevelDivisions firstLevelDivisions : allFirstLevelDivisions) {

            if (firstLevelDivisions.getCountriesID().contains(productName)) {

                productNameSearch.add(firstLevelDivisions);

            }
        }

        return productNameSearch;

    }
}
