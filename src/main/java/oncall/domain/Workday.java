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
}
