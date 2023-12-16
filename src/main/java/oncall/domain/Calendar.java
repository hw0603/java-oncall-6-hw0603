package oncall.domain;

import java.util.HashMap;
import java.util.Map;

public class Calendar {
    private Map<Integer, Workday> calendar = new HashMap<>();

    public void addWorkday(int date, Workday workday) {
        calendar.put(date, workday);
    }
}
