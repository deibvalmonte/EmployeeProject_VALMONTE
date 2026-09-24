package version2;

import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (month == 0) {
            this.day = day;
            return;
        }
        validateDate(day, month, year);
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (year == 0) {
            this.month = month;
            return;
        }
        validateDate(day, month, year);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (month == 0) {
            this.year = year;
            return;
        }
        validateDate(day, month, year);
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 0) {
            return false;
        }

        int maxDay = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };

        return day >= 1 && day <= maxDay;
    }

    public void displayDate() {
        System.out.println(this);
    }

    private void validateDate(int newDay, int newMonth, int newYear) {
        if (!isValidDate(newDay, newMonth, newYear)) {
            throw new IllegalArgumentException("Invalid date: " + newDay + "/" + newMonth + "/" + newYear);
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%02d %s %04d", day, MONTH_NAMES[month - 1], year);
    }
}


