package oncall.constant;

import java.util.List;
public class LastDate {
    public static final List<Integer> LAST_DATE = List.of(-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    private LastDate() {
    }

    public static int of(int month) {
        return LAST_DATE.get(month);
    }
}
