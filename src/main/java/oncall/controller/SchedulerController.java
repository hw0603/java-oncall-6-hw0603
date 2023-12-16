package oncall.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;
import oncall.constant.WeekType;
import oncall.service.CalendarService;
import oncall.service.WorkTableService;
import oncall.util.DateValidator;
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
    }

    private Entry<Integer, String> receiveValidatedMonthAndWeekType() {
        OutputView.printDateInputMessage();
        return receiveValidatedInput(InputView::inputMonthAndWeektype, DateValidator::validateDate);
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
