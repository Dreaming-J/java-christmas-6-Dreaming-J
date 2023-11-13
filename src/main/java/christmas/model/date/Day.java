package christmas.model.date;

import java.util.stream.Stream;

public enum Day {
    MONDAY(4, Week.WEEKDAY),
    TUESDAY(5, Week.WEEKDAY),
    WEDNESDAY(6, Week.WEEKDAY),
    THURSDAY(0, Week.WEEKDAY),
    FRIDAY(1, Week.WEEKEND),
    SATURDAY(2, Week.WEEKEND),
    SUNDAY(3, Week.WEEKDAY);

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
        return this.week == Week.WEEKDAY;
    }

    public boolean isWeekend() {
        return this.week == Week.WEEKEND;
    }

    public boolean isSunday() {
        return this == SUNDAY;
    }
}
