package designpatterns.templatemethod.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveDataQuery extends DatabaseTemplate {

    @Override
    void execute(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Data: " + resultSet.getString("data"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
