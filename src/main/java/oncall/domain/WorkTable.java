package oncall.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorkTable {
    private final Map<Workday, Developer> table = new LinkedHashMap<>();

    public void add(Workday workday, Developer developer) {
        table.put(workday, developer);
    }

    public Developer get(Workday workday) {
        return table.get(workday);
    }

    public Map<Workday, Developer> getTable() {
        return table;
    }
}
