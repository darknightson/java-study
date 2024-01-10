package constructor;

public class MockDatabaseManager extends DatabaseManager {
    @Override
    public void connect() {
        // 테스트 용도로 사용
        System.out.println("Mock database connected");
    }
}
