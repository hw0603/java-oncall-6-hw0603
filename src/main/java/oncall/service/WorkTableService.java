package oncall.service;

import java.util.List;

public class WorkTableService {
    public void validateRotations(List<List<String>> rotations) {
        List<String> weekDayRotation = rotations.get(0);
        List<String> weekendRotation = rotations.get(1);

    }
}
