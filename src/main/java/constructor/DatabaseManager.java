package constructor;

public class DatabaseManager {
    public static DatabaseManager INSTANCE = new DatabaseManager();

    public static DatabaseManager getInstance() {
        return INSTANCE;
    }

    public void connect() {
        // 데이터베이스 연결 로직
        System.out.println("connect");
    }
}
