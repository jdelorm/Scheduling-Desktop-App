package delorme.john.helper;

import delorme.john.models.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class countriesJDBC {

    public static ObservableList<Countries> getCountries() throws SQLException {

        ObservableList<Countries> countriesListQuery = FXCollections.observableArrayList();

        String sql = "SELECT Country_ID, Country from countries";

        PreparedStatement preparedStatementCountry = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementCountry.executeQuery();

        while (results.next()) {

            int countryID = results.getInt("Country_ID");
            String countryName = results.getString("Country");

            Countries country = new Countries(countryID, countryName);

            countriesListQuery.add(country);

        }

        return countriesListQuery;
    }
}
