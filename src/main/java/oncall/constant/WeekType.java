package oncall.constant;

public enum WeekType {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String name;

    public String getName() {
        return name;
    }

    WeekType(String name) {
        this.name = name;
    }
}
