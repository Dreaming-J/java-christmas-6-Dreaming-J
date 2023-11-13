package christmas.model.reservation.date;

import static christmas.model.reservation.date.Week.WEEKDAY;
import static christmas.model.reservation.date.Week.WEEKEND;

import java.util.stream.Stream;

public enum Day {
    MONDAY(4, WEEKDAY),
    TUESDAY(5, WEEKDAY),
    WEDNESDAY(6, WEEKDAY),
    THURSDAY(0, WEEKDAY),
    FRIDAY(1, WEEKEND),
    SATURDAY(2, WEEKEND),
    SUNDAY(3, WEEKDAY);

    private final int date;
    private final Week week;

    Day(int date, Week week) {
        this.date = date;
        this.week = week;
    }

    public static Day from(int date) {
        return Stream.of(values())
                .filter(day -> day.date == date % 7)
                .findFirst()
                .get();
    }

    public boolean isWeekday() {
        return this.week == WEEKDAY;
    }

    public boolean isWeekend() {
        return this.week == WEEKEND;
    }

    public boolean isSunday() {
        return this == SUNDAY;
    }
}
