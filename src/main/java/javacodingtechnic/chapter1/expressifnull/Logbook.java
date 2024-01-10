package javacodingtechnic.chapter1.expressifnull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Collections;

public class Logbook {

    private void writeMessage(String message, Path location) throws IOException {
        // null 발생
        if (Files.isDirectory(location)) { // 경로가 존재한다면 에러
            throw new IllegalArgumentException("The path is invalid");
        }
        if ( message.trim().equals("") || message == null ) {
            throw new IllegalArgumentException("The message is invalid");
        }
        String entry = LocalDateTime.now() + ":" + message;
        Files.write(location, Collections.singletonList(entry),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }

    // solution , null 체크가 항상 앞에 와야 한다.
    private void writeMessage1(String message, Path location) throws IOException {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("The message is invalid");
        }
        if (location == null || Files.isDirectory(location)) {
            throw new IllegalArgumentException("The path is invalid");
        }
        String entry = LocalDateTime.now() + ":" + message;
        Files.write(location, Collections.singletonList(entry),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }


    public static void main(String[] args) throws IOException {

        Logbook logbook = new Logbook();
        //String path = "/Users/anthony/2023stud1";
        String message = null;
        logbook.writeMessage(null, Path.of("/Users/anthony/2023stud2"));
    }
}
