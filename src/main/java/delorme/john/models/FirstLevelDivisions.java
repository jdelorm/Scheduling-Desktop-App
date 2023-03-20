package delorme.john.models;

public class FirstLevelDivisions {

    private int divisionID;
    private String division;
    public int countryID;

    public FirstLevelDivisions(int divisionID, String division, int countryID) {

        this.divisionID = divisionID;
        this.division = division;
        this.countryID = countryID;

    }

    public int getDivisionID() {

        return divisionID;

    }

    public String getDivision() {

        return division;

    }

    public int getCountryID() {

        return countryID;
    }

    public void setDivisionID(int divisionID) {

        this.divisionID = divisionID;

    }

    public void setDivision(String division) {

        this.division = division;

    }

    public void setCountryID(int countryID) {

        this.countryID = countryID;

    }
}
