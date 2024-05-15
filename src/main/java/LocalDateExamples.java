import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateExamples {

    /* Java 8 introduced a new and improved date and time API that addresses many of the shortcomings of the older java.util.Date and java.util.Calendar classes.
       The new date and time API is part of the java.time package and provides more comprehensive, flexible, and easy-to-use functionality */

    public static void main(String[] args) {

        //LocalDate Examples
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2014, 02, 20);

        System.out.println(localDate1);
        System.out.println(localDate2);

        //LocalTime
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(10, 30);

        System.out.println(localTime1);
        System.out.println(localTime2);

        //LocalDateTime Examples
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2018, 02, 28, 9, 30, 20);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        /*
        Period:
        •Period is a date -based representation of time in Days, Months and Years and is part of the java.time package.
        •Compatible with LocalDate.
        •It represents a Period of Time not just a specific date and time
         */

        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofYears(2);

        System.out.println(period1 + "  " + period2);

       /* Period : Use-Case (Period - To compare Dates)
        • Mainly used calculate the difference between the two dates.*/

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);


       /* Duration
        • A time based representation of time in hours , minutes, seconds and nanoseconds.
        • Compatible with LocalTime and LocalDateTime
        • It represents a duration of time not just a specific time.*/

        Duration duration1 = Duration.ofHours(3);
        Duration duration2 = Duration.ofMinutes(20);

        System.out.println(duration1 + "  " + duration2);

      /*  Duration : Use-Case(Duration - To compare Time)
        It can be used to calculate the difference between the time
        objects such as LocalTime and LocalDateTime.*/

        Duration duration = Duration.between(localTime1, localDateTime2);
        System.out.println(duration);

       /* Instant:
         • Represent the time in a machine readable format.

         - Represents the time in seconds from January 01,1970 (EPOCH)
           to current time as a huge number*/

        Instant instant = Instant.now();
        System.out.println(instant);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime1, ZoneId.of("America/Chicago"));
        System.out.println(zonedDateTime);

        /*DateTimeFormatter
         • Introduced in Java 8 and part of the java.time.format
           package.
         • Used to parse and format the LocalDate, LocalTime and
          LocalDateTime.*/

        String input = "2023-08-11 15:30:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parsedDateTime = LocalDateTime.parse(input, formatter);
        System.out.println(parsedDateTime);

    }
}
