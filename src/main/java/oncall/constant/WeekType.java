package oncall.constant;

public enum WeekType {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String name;
    private final int index;

    public static WeekType of(String value) {
        for (WeekType weekType : WeekType.values()) {
            if (weekType.name.equals(value)) {
                return weekType;
            }
        }
        throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
    }

    public static WeekType fromIdx(int idx) {
        for (WeekType weekType : WeekType.values()) {
            if (weekType.index == idx) {
                return weekType;
            }
        }
        throw new IllegalArgumentException(ProgramConstant.INVALID_INPUT_ERROR);
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public boolean isWeekday() {
        return this.index < 5;
    }

    WeekType(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
