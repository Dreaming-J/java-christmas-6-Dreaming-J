package christmas.model.reservation.date;

import christmas.exception.Exception.DateException;

public record Date(int date) {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public Date {
        validate(date);
    }

    private void validate(int date) {
        if (isUnderMin(date) || isOverMax(date)) {
            throw new DateException();
        }
    }

    private boolean isUnderMin(int date) {
        return date < MIN_DATE;
    }

    private boolean isOverMax(int date) {
        return date > MAX_DATE;
    }

    public Day findDay() {
        return Day.from(date);
    }

    public boolean isWeekday() {
        return findDay().isWeekday();
    }
}
