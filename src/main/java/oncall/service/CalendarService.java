package oncall.service;

import oncall.constant.Holiday;
import oncall.constant.LastDate;
import oncall.constant.WeekType;
import oncall.domain.Calendar;
import oncall.domain.Workday;

public class CalendarService {
    public Calendar createCalendar(Integer month, WeekType weekType) {
        Calendar calendar = new Calendar();

        int weekIndex = weekType.getIndex();
        for (int date = 1; date <= LastDate.of(month); date++) {
            weekIndex = weekIndex % 7;
            calendar.addWorkday(date, new Workday(date, WeekType.fromIdx(weekIndex), Holiday.isHoliday(month, date)));
            weekIndex++;
        }

        return calendar;
    }
}
