package constructor;

public enum DatabaseConnection {
    INSTANCE;

    private String connectionString;

    DatabaseConnection() {
        // 기본 연결 문자열
        this.connectionString = "jdbc:mysql://localhost:3306/mydatabase"; // 기본값
    }

    public void setConnectionString(String newConnectionString) {
        this.connectionString = newConnectionString;
    }

    public void connect() {
        // 데이터베이스 연결
        System.out.println("Connecting to database: " + connectionString);
        // 실제 연결 로직...
    }

    public void disconnect() {
        // 데이터베이스 연결 해제
        System.out.println("Disconnecting from database.");
        // 실제 연결 해제 로직...
    }

    // 기타 메소드들...
}
