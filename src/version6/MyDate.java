package version6;

import java.util.Locale;

public final class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @SuppressWarnings("this-escape")

    public MyDate() {
        this(1, 1, 2000);
    }

    @SuppressWarnings("this-escape")

    public MyDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        if (year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        int maxDay = getMaxDayForMonth(month, year);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        int maxDay = getMaxDayForMonth(this.month, this.year);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        int maxDay = getMaxDayForMonth(month, this.year);
        if (this.day < 1 || this.day > maxDay) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        int maxDay = getMaxDayForMonth(this.month, year);
        if (this.day < 1 || this.day > maxDay) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (year <= 1900) {
            return false;
        }

        int maxDay = getMaxDayForMonth(month, year);
        return day >= 1 && day <= maxDay;
    }

    private static int getMaxDayForMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid calendar date");
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%02d %s %04d", day, MONTH_NAMES[month - 1], year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
