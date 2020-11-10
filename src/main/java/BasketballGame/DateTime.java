package BasketballGame;

public class DateTime {

    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;


    public DateTime(int year, int month, int day, int hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

    public DateTime(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public DateTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
}
}
