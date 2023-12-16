package oncall.constant;

import java.util.Map;
import java.util.Set;

public class Holiday {
    public static final Map<Integer, Set<Integer>> holidays = Map.ofEntries(
            Map.entry(1, Set.of(1)),
            Map.entry(3, Set.of(1)),
            Map.entry(5, Set.of(5)),
            Map.entry(6, Set.of(6)),
            Map.entry(8, Set.of(15)),
            Map.entry(10, Set.of(3, 9)),
            Map.entry(12, Set.of(25))
    );

    private Holiday() {
    }

    public static boolean isHoliday(int month, int date) {
        return holidays.get(month).contains(date);
    }
}
