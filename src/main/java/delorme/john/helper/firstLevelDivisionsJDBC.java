package delorme.john.helper;

import delorme.john.models.FirstLevelDivisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class firstLevelDivisionsJDBC {

    public static ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() throws SQLException {

        ObservableList<FirstLevelDivisions> firstLevelDivisionsListQuery = FXCollections.observableArrayList();

        String sql = "SELECT * from first_level_divisions";

        PreparedStatement preparedStatementDivision = JDBC.getConnection().prepareStatement(sql);

        ResultSet results = preparedStatementDivision.executeQuery();

        while (results.next()) {

            int divisionID = results.getInt("Division_ID");
            String divisionName = results.getString("Division");
            int country_ID = results.getInt("COUNTRY_ID");

            FirstLevelDivisions firstLevelDivision = new FirstLevelDivisions(divisionID, divisionName, country_ID);

            firstLevelDivisionsListQuery.add(firstLevelDivision);

        }

        return firstLevelDivisionsListQuery;

    }
}
