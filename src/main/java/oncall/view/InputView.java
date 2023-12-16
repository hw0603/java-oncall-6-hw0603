package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Map.Entry;

public class InputView {
    private static final String INVALID_INPUT_ERROR = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    public static Entry<Integer, String> inputMonthAndWeektype() {
        String userInput = Console.readLine();
        String[] splittedString = userInput.split(",");

        if (splittedString.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        try {
            return Map.entry(Integer.parseInt(splittedString[0]), splittedString[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
