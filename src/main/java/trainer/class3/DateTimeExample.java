package trainer.class3;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by marutsingh on 6/9/16.
 */
public class DateTimeExample {
    public void testLocalDateTime(){


// 1979-02-15
        LocalDate nov13th = LocalDate.of(1979, Month.NOVEMBER, 13);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        String formattedDate = date1.format(DateTimeFormatter.ofPattern("DD MM YYYY"));

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    public Instant getInstant(){
        Instant now = Instant.now();
        return now;
    }

    public Instant parseToInstantFromISOFormat(){
        Instant fromIso8601 = Instant.parse("2015-07-10T12:00:00Z");
        return fromIso8601;
    }

    public ZonedDateTime getTimeWithZone(LocalDateTime dateTime){
        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Europe/Berlin"));
        return berlinDateTime;
    }

    public Period getDifferenceBetweenDates(LocalDate localDate, LocalDate localDate2){
        return Period.between(localDate,localDate2);
    }

    public Duration getDuration(){
        Duration gap = Duration.ofSeconds(10);
        return gap;
    }

    public long getDifferenceBetweenInstants(Instant t1, Instant t2){
        long ns = Duration.between(t1, t2).toNanos();
        return ns;
    }

    public long getDifferenceBetweenInstants(LocalDateTime t1, LocalDateTime t2){
        long ns = Duration.between(t1, t2).toNanos();
        return ns;
    }
}
