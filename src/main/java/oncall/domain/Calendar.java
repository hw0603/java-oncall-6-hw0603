package oncall.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private final Map<Integer, Workday> calendar = new HashMap<>();

    public void addWorkday(int date, Workday workday) {
        calendar.put(date, workday);
    }

    public List<Workday> getWorkdays() {
        return Arrays.asList(calendar.values().toArray(new Workday[0]));
    }
}
