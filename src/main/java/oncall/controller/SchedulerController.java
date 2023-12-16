package oncall.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;
import oncall.constant.WeekType;
import oncall.domain.Calendar;
import oncall.service.CalendarService;
import oncall.service.WorkTableService;
import oncall.util.DateValidator;
import oncall.util.RotationValidator;
import oncall.view.OutputView;
import oncall.view.InputView;

public class SchedulerController {
    private CalendarService calendarService;
    private WorkTableService workTableService;

    public SchedulerController(CalendarService calendarService, WorkTableService workTableService) {
        this.calendarService = calendarService;
        this.workTableService = workTableService;
    }

    public void start() {
        Entry<Integer, String> monthAndWeekType = receiveValidatedMonthAndWeekType();
        Calendar calendar = calendarService.createCalendar(monthAndWeekType.getKey(), WeekType.of(monthAndWeekType.getValue()));
//        System.out.println(calendar);

        List<List<String>> rotations = receiveValidatedRotations();
//        System.out.println(rotations);

    }

    private Entry<Integer, String> receiveValidatedMonthAndWeekType() {
        OutputView.printDateInputMessage();
        return receiveValidatedInput(InputView::inputMonthAndWeektype, DateValidator::validateDate);
    }

    private List<List<String>> receiveValidatedRotations() {
        return receiveValidatedInput(InputView::inputRotations, RotationValidator::validateRotations);
    }

    private static <T> T receiveValidatedInput(Supplier<T> inputSupplier, Consumer<T> validator) {
        while (true) {
            try {
                T input = inputSupplier.get();
                validator.accept(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }
}
