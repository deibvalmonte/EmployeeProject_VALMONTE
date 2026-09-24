package version5;

import java.util.Locale;
import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    public MyDate() { this(1,1,2000); }
    public MyDate(int day, int month, int year) { if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date"); this.day = day; this.month = month; this.year = year; }

    public int getDay() { return day; }
    public void setDay(int day) { if (!isValidDate(day, this.month, this.year)) throw new IllegalArgumentException("Invalid day"); this.day = day; }
    public int getMonth() { return month; }
    public void setMonth(int month) { if (!isValidDate(this.day, month, this.year)) throw new IllegalArgumentException("Invalid month"); this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { if (!isValidDate(this.day, this.month, year)) throw new IllegalArgumentException("Invalid year"); this.year = year; }

    public static boolean isLeapYear(int year) { return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        if (year < 0) return false;
        int maxDay;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: maxDay = 31; break;
            case 4: case 6: case 9: case 11: maxDay = 30; break;
            case 2: maxDay = isLeapYear(year) ? 29 : 28; break;
            default: maxDay = 0;
        }
        return day >= 1 && day <= maxDay;
    }

    @Override
    public String toString() { return String.format(Locale.US, "%02d %s %04d", day, MONTH_NAMES[month-1], year); }

    @Override
    public MyDate clone() { try { return (MyDate) super.clone(); } catch (CloneNotSupportedException e) { throw new AssertionError(e); } }

    @Override
    public boolean equals(Object obj) { if (this == obj) return true; if (!(obj instanceof MyDate)) return false; MyDate other = (MyDate) obj; return this.day == other.day && this.month == other.month && this.year == other.year; }

    @Override
    public int hashCode() { return Objects.hash(day, month, year); }
}
