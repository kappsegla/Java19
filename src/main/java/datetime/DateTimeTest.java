package datetime;


import java.time.*;

public class DateTimeTest {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2017-12-31");
        LocalDate date2 = LocalDate.now();
        LocalDate date3 = LocalDate.of(2017, 12, 31);
        LocalDate date4 = LocalDate.of(2017, Month.DECEMBER, 31);
        LocalDate date5 = LocalDate.now(ZoneId.of("America/New_York"));

        LocalTime time = LocalTime.now();

        LocalDateTime a = LocalDateTime.parse("2017-12-31T23:59:59.123456789");
        //this fails; you need to pass the 'T'
        //LocalDateTime b = LocalDateTime.parse("2017-12-31 23:59:59.123456789");
        LocalDateTime b = LocalDateTime.now();
        LocalDateTime c = LocalDateTime.of(2017,12,31,18,59,59);
        LocalDateTime d = LocalDateTime.of(2017,12,31,18,59,59,1); //with nanos at the end
    }
}
