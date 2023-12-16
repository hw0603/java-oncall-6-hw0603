package oncall.util;

import java.util.Map.Entry;
import java.util.Set;
import oncall.constant.ProgramConstant;

public class DateValidator {
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    public static final Set<String> VALID_WEEKTYPE = Set.of("월", "화", "수", "목", "금", "토", "일");

    public static void validateDate(Entry<Integer, String> monthAndWeektype) {
        validateMonth(monthAndWeektype.getKey());
        validateWeektype(monthAndWeektype.getValue());
    }

    private static void validateMonth(Integer month) {
        if (!isInRange(month)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
    }

    private static void validateWeektype(String weektype) {
        if (!isAcceptableWeektype(weektype)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
    }

    private static boolean isInRange(int month) {
        return MIN_MONTH <= month && month <= MAX_MONTH;
    }

    private static boolean isAcceptableWeektype(String weektype) {
        return VALID_WEEKTYPE.contains(weektype);
    }
}
