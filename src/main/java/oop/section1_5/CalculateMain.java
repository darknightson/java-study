package oop.section1_5;

public class CalculateMain {

    public static void main(String[] args) {
        CalculateCommand calculateCommand = new CalculateCommand(CalculateType.MULTIPLY, 2, 5);
        Client client = new Client();
        int i = client.someMethod(calculateCommand);
        System.out.println("i = " + i);
    }
}
