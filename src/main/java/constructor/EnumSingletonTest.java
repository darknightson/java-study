package constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
        // 싱글턴 인스턴스에 접근
        //DatabaseConnection connection = DatabaseConnection.INSTANCE;

        // Oracle 데이터베이스 연결 문자열로 설정
         String oracleConnectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
         DatabaseConnection.INSTANCE.setConnectionString(oracleConnectionString);

        // 데이터베이스 연결
        DatabaseConnection.INSTANCE.connect();

        // 필요한 작업 수행...

        // 데이터베이스 연결 해제
        // 엔터프라이즈 어플리케이션 아키텍처 패턴
        DatabaseConnection.INSTANCE.disconnect();

        System.out.println("Math.abs(1) = " + Math.abs(1));
    }
}
