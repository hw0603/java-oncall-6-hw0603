package oncall.util;

import java.util.HashSet;
import java.util.List;
import oncall.constant.ProgramConstant;

public class RotationValidator {
    private static final int MIN_ROTATION_SIZE = 5;
    private static final int MAX_ROTATION_SIZE = 35;
    private static final int MAX_NICKNAME_LENGTH = 5;

    public static void validateRotations(List<List<String>> rotations) {
        List<String> weekDayRotation = rotations.get(0);
        List<String> weekendRotation = rotations.get(1);

        validateOneRotation(weekDayRotation);
        validateOneRotation(weekendRotation);

        // 평일 순번과 주말 순번에 각각 1회씩 편성되어 있는지 검증
        if (!isAllNicknameExist(weekDayRotation, weekendRotation)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
    }

    private static void validateOneRotation(List<String> rotation) {
        if (!isRotationSizeInRange(rotation)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
        if (!isNicknameLengthInRange(rotation)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
        if (isDuplicatedNicknameExist(rotation)) {
            throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
        }
    }

    private static boolean isRotationSizeInRange(List<String> rotation) {
        return MIN_ROTATION_SIZE <= rotation.size() && rotation.size() <= MAX_ROTATION_SIZE;
    }

    private static boolean isNicknameLengthInRange(List<String> rotation) {
        return rotation.stream()
                .allMatch(RotationValidator::isNicknameLengthInRange);
    }

    private static boolean isNicknameLengthInRange(String nickname) {
        return !nickname.isEmpty() && nickname.length() <= MAX_NICKNAME_LENGTH;
    }

    private static boolean isDuplicatedNicknameExist(List<String> rotation) {
        return rotation.stream()
                .distinct()
                .count() != rotation.size();
    }

    private static boolean isAllNicknameExist(List<String> weekDayRotation, List<String> weekendRotation) {
        return new HashSet<>(weekendRotation).containsAll(weekDayRotation);
    }

}
