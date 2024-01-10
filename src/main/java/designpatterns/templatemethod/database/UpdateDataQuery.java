package designpatterns.templatemethod.database;

import java.sql.SQLException;

public class UpdateDataQuery extends DatabaseTemplate {
    @Override
    void execute(String query) {
        try {
            int rowsAffected = statement.executeUpdate(query);
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
