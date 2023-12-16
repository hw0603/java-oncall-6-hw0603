package oncall.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;
import oncall.constant.WeekType;
import oncall.domain.Calendar;
import oncall.domain.Rotation;
import oncall.service.CalendarService;
import oncall.service.RotationService;
import oncall.service.WorkTableService;
import oncall.util.DateValidator;
import oncall.util.RotationValidator;
import oncall.view.OutputView;
import oncall.view.InputView;

public class SchedulerController {
    private CalendarService calendarService;
    private WorkTableService workTableService;
    private RotationService rotationService;

    private Calendar calendar;
    private Rotation weekDayRotation;
    private Rotation weekendRotation;

    public SchedulerController(CalendarService calendarService, WorkTableService workTableService, RotationService rotationService) {
        this.calendarService = calendarService;
        this.workTableService = workTableService;
        this.rotationService = rotationService;
    }

    public void init() {
        Entry<Integer, String> monthAndWeekType = receiveValidatedMonthAndWeekType();
        calendar = calendarService.createCalendar(monthAndWeekType.getKey(), WeekType.of(monthAndWeekType.getValue()));
        List<List<String>> rotations = receiveValidatedRotations();
        weekDayRotation = rotationService.createRotation(rotations.get(0));
        weekendRotation = rotationService.createRotation(rotations.get(1));
    }

    public void schedule() {
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
