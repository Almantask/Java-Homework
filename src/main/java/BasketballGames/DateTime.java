package BasketballGames;

import java.time.LocalTime;

public class DateTime {
    private final Integer year;
    private final Integer month;
    private final Integer day;
    private final LocalTime time;

    public DateTime(Integer year, Integer month, Integer day, LocalTime time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }
}