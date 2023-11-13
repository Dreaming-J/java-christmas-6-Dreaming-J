package christmas.model.date;

import static christmas.config.DateConfig.CHRISTMAS_DATE;
import static christmas.config.DateConfig.MAX_DATE;
import static christmas.config.DateConfig.MIN_DATE;

import christmas.exception.Exception.DateException;

public record Date(int date) {
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

    public boolean isWeekend() {
        return findDay().isWeekend();
    }

    public boolean hasStar() {
        return isSunday() || isChristmas();
    }

    private boolean isSunday() {
        return findDay().isSunday();
    }

    private boolean isChristmas() {
        return this.date == CHRISTMAS_DATE;
    }
}
