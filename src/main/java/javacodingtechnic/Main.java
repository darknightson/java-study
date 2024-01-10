package javacodingtechnic;

public class Main {

    public static void main(String[] args) {
        // 1 부터 max 까지 fizz buzz 출력
        int from = 1;
        int to = 100;

        FizzBuzz fizzBuzz = new ConsoleBasedFizzBuzz();
        fizzBuzz.print(from, to);
    }
}
