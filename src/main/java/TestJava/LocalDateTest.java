package TestJava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);

        convertDateFromText("2023-08-21 18:00");
    }
    public static void convertDateFromText(String endDate) {
        LocalDateTime parsedDate = LocalDateTime.parse(endDate + ":00", DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss][yyyyMMdd HH:mm:ss][yyyy-MM-dd HH:mm]"));
        System.out.println("parsedDate = " + parsedDate);

    }
//
//
//    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyyMMdd]");
//    LocalDateTime parsedDate = LocalDateTime.parse(endDate + " 23:59:00", inputFormatter);
//        System.out.println(parsedDate);

}
