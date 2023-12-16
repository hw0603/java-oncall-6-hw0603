package oncall.domain;

import oncall.constant.WeekType;

public class Workday {
    private final int date;
    private final WeekType weekday;
    private final boolean isHoliday;

    public Workday(int date, WeekType weekday, boolean isHoliday) {
        this.date = date;
        this.weekday = weekday;
        this.isHoliday = isHoliday;
    }

    public boolean isWeekday() {
        return this.weekday.isWeekday();
    }

    public boolean isHoliday() {
        return this.isHoliday;
    }

    public int getDate() {
        return this.date;
    }

    public String getWeekType() {
        return this.weekday.getName();
    }
}
