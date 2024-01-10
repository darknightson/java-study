package oop.section1_6;

public class CheckedExceptionMain {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.throwCheckedException();
        } catch (CheckedException e) {
            // 예외에 대한 적절한 처리
        }

        client.tryCatchCheckedException();
    }
}
