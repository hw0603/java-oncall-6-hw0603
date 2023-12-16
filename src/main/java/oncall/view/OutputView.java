package oncall.view;

import java.util.Map;
import java.util.Map.Entry;
import oncall.domain.Developer;
import oncall.domain.Workday;

public class OutputView {
    private static final String DATE_INPUT_DESC = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ROTATION_INPUT_DESC = "비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String WEEKDAY = "평일 ";
    private static final String WEEKEND = "휴일 ";
    private static final String ERROR_MSG_PREFIX = "[ERROR] ";


    public static void printDateInputMessage() {
        System.out.println(DATE_INPUT_DESC);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(ERROR_MSG_PREFIX + e.getMessage());
    }

    public static void printWeekdayRotationInputMessage() {
        System.out.println(WEEKDAY + ROTATION_INPUT_DESC);
    }

    public static void printWeekendRotationInputMessage() {
        System.out.println(WEEKEND + ROTATION_INPUT_DESC);
    }

    public static void printTable(int month, Map<Workday, Developer> table) {
        for (Entry<Workday, Developer> entry : table.entrySet()) {
            Workday wd = entry.getKey();
            String sb = month + "월 " + wd.getDate() + "일 "
                    + wd.getWeekType() + makeHolidayIndicator(wd)
                    + entry.getValue().getName();
            System.out.println(sb);
        }
    }
    private static String makeHolidayIndicator(Workday wd) {
        if (wd.isWeekday() && wd.isHoliday()) {
            return "(휴일) ";
        }
        return " ";
    }
}
