package oncall.service;


import oncall.domain.Calendar;
import oncall.domain.Developer;
import oncall.domain.Rotation;
import oncall.domain.WorkTable;
import oncall.domain.Workday;

public class WorkTableService {
    WorkTable workTable = new WorkTable();
    String lastWorkerName = "";
    public WorkTable createWorkTable(Calendar calendar, Rotation weekDayRotation, Rotation weekendRotation) {
        for (Workday workday : calendar.getWorkdays()) {
            if (!workday.isWeekday() || workday.isHoliday()) {
                selectWorker(workday, weekendRotation);
                continue;
            }
            selectWorker(workday, weekDayRotation);
        }

        return workTable;
    }

    private void selectWorker(Workday workday, Rotation rotation) {
        Developer candidate = rotation.pop();

        if (candidate.getName().equals(lastWorkerName)) {
            rotation.bufferadd(candidate);
            candidate = rotation.popOrig();
        }

        workTable.add(workday, candidate);
        lastWorkerName = candidate.getName();
        rotation.add(candidate);
    }
}
