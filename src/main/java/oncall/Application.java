package oncall;

import oncall.controller.SchedulerController;
import oncall.service.CalendarService;
import oncall.service.WorkTableService;
import oncall.service.RotationService;

public class Application {
    public static void main(String[] args) {
        SchedulerController schedulerController = new SchedulerController(
                new CalendarService(),
                new WorkTableService(),
                new RotationService()
        );
        schedulerController.init();
        schedulerController.schedule();
        schedulerController.print();
    }
}
