package christmas.model.event;

import static christmas.Config.COMMA_FORMATTER;
import static christmas.Config.ConfigChristmasDdayEvent.CHRISTMAS_DDAY_EVENT_MESSAGE;
import static christmas.Config.ConfigChristmasDdayEvent.DISCOUNT_UNIT;
import static christmas.Config.ConfigChristmasDdayEvent.END_DATE;
import static christmas.Config.ConfigChristmasDdayEvent.START_DATE;
import static christmas.Config.ConfigChristmasDdayEvent.START_DISCOUNT;
import static christmas.util.Constant.EMPTY;

import christmas.model.reservation.date.Date;

public class ChristmasDdayEvent extends Event {
    public ChristmasDdayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean isFitCondition() {
        return super.isFitCondition() && isBetweenDate();
    }

    private boolean isBetweenDate() {
        return date.date() >= START_DATE && date.date() <= END_DATE;
    }

    @Override
    public void applyBenefit(int date) {
        if (!isFitCondition()) {
            return;
        }

        this.discount = START_DISCOUNT +
                DISCOUNT_UNIT * (date - 1);
    }

    @Override
    public String toString() {
        if (!existsDiscount()) {
            return EMPTY;
        }

        return String.format(CHRISTMAS_DDAY_EVENT_MESSAGE, COMMA_FORMATTER.format(this.discount));
    }
}
