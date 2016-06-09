package trainer.class3;

import java.time.*;

/**
 * Created by marutsingh on 6/9/16.
 */
public class DateTimeExample {
    public void testLocalDateTime(){


// 1979-02-15
        LocalDate nov13th = LocalDate.of(1979, Month.NOVEMBER, 13);

        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        // Current time
        Instant now = Instant.now();
        Instant fromIso8601 = Instant.parse("2015-07-10T12:00:00Z");
    }

    public ZonedDateTime getTimeWithZone(LocalDateTime dateTime){
        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Europe/Berlin"));
        return berlinDateTime;
    }
}
