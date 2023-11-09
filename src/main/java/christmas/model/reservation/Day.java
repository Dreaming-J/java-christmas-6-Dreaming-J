package christmas.model.reservation;

import java.util.stream.Stream;

public enum Day {
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(0),
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    private final int date;

    Day(int date) {
        this.date = date;
    }

    public static Day from(int date) {
        return Stream.of(values())
                .filter(day -> day.date == date % 7)
                .findFirst()
                .get();
    }
}
