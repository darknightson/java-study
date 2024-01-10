package designpatterns.templatemethod.database;

public class DatabaseTemplatePatternExample {

    public static void main(String[] args) {
        DatabaseTemplate retrieveQuery = new RetrieveDataQuery();
        System.out.println("Retrieving data...");
        retrieveQuery.executeQuery("SELECT data FROM member");

        DatabaseTemplate updateQuery = new UpdateDataQuery();
        updateQuery.executeQuery("UPDATE member SET name = 'template method' WHERE member_id = 1");
    }
}
