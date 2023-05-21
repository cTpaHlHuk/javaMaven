package Lesson16;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
//        String date = ("1950-10-09T15:12:01.213Z");
//        LocalDate date2 = LocalDate.parse(("1950-10-09T15:12:01.213Z"));
//        System.out.println(date2);                                 //dd/MMM/yyyy


        String date = ("1950-10-09T15:12:01.213Z");
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       // ZonеdDateTime dateTime = ZonеdDateTime.parse(date, format);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
        System.out.println(zonedDateTime);
    }
}
