package oop.section3_2;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.someClientMethod(new Child());
    }
    public void someClientMethod(Parent parentOrChild) {
        parentOrChild.someMethod(1);

       // parentOrChild.someMethod(-1); // 클라이언트 입장에서는 해당 parentOrChild 가 Parent 인지 Child 인지 알 수 없다.
    }
}
