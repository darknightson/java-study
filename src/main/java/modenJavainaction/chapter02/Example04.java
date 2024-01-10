package modenJavainaction.chapter02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example04 {

    public static void main(String[] args) throws IOException {
        final String s = processFile();
        System.out.println("s = " + s);
    }

    public static String processFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReader.readLine();
        }
    }
}
