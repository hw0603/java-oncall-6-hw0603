package oncall.service;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Developer;
import oncall.domain.Rotation;

public class RotationService {
    public Rotation createRotation(List<String> rotationWithName) {
        Rotation rotation = new Rotation();
        Arrays.stream(rotationWithName.toArray()).map(name -> new Developer((String) name)).forEach(rotation::add);
        return rotation;
    }
}
