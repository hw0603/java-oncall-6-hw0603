package oncall.view;

public class OutputView {
    private static final String DATE_INPUT_DESC = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ERROR_MSG_PREFIX = "[ERROR] ";


    public static void printDateInputMessage() {
        System.out.println(DATE_INPUT_DESC);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(ERROR_MSG_PREFIX + e.getMessage());
    }
}
