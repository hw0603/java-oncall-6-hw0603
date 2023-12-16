package oncall.view;

public class OutputView {
    public static final String DATE_INPUT_DESC = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public static void printDateInputMessage() {
        System.out.println(DATE_INPUT_DESC);
    }
}
