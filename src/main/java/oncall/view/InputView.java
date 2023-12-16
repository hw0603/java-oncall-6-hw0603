package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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

    public static List<List<String>> inputRotations() {
        String weekdayRotationInput = inputWeekdayRotation();
        String weekendRotationInput = inputWeekendRotation();
        List<String> weekdayRotations = List.of(weekdayRotationInput.split(","));
        List<String> weekendRotations = List.of(weekendRotationInput.split(","));

        if (!rotationSizeIsValid(weekdayRotations, weekendRotations)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        try {
            return List.of(weekdayRotations, weekendRotations);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private static String inputWeekdayRotation() {
        OutputView.printWeekdayRotationInputMessage();
        return Console.readLine();
    }

    private static String inputWeekendRotation() {
        OutputView.printWeekendRotationInputMessage();
        return Console.readLine();
    }

    private static boolean rotationSizeIsValid(List<String> weekdayRotations, List<String> weekendRotations) {
        return weekdayRotations.size() == weekendRotations.size();
    }
}
