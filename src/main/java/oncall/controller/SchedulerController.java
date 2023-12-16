package oncall.controller;

import java.util.Map;
import oncall.constant.WeekType;
import oncall.service.CalendarService;
import oncall.service.WorkTableService;
import oncall.view.OutputView;

public class SchedulerController {
    private CalendarService calendarService;
    private WorkTableService workTableService;

    public SchedulerController(CalendarService calendarService, WorkTableService workTableService) {
        this.calendarService = calendarService;
        this.workTableService = workTableService;
    }

    public void start() {
        receiveValidatedDate();
    }

    private Map<Integer, WeekType> receiveValidatedDate() {
        OutputView.printDateInputMessage();
        return null;
    }
}
