package designpatterns.templatemethod.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseTemplate {

    protected Connection connection;
    protected Statement statement;


    // Template method to execute a database query
    final void executeQuery(String query) {
        establishConnection();
        createStatement();
        execute(query);
        closeResources();
    }

    abstract void execute(String query);

    void establishConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "1115");
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeResources() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
