package org.example;

import java.time.*;

public class LocalDateCode {
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        LocalDate date2 = LocalDate.of(2026,01,07);

//        System.out.println(date.plusDays(10));
////        System.out.println(date2);
//        LocalDate date3 = LocalDate.of(2023,01,01);
//        Period period = Period.between(date2,LocalDate.now());
//        System.out.println(period);

        LocalTime localTime = LocalTime.of(2,30);
        System.out.println(localTime);
        LocalTime localTime1 = LocalTime.of(3,30);
        System.out.println(localTime1);
        Duration duration = Duration.between(localTime,localTime1);
        System.out.println(duration.toHours());

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime xo = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        Instant instant = Instant.now();
        System.out.println(instant); // gives you utc time

        System.out.println(zdt);
    }
}
