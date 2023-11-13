package christmas.model.event;

import static christmas.config.EventConfig.COMMA_FORMATTER;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.DISCOUNT_UNIT;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.END_DATE;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.START_DATE;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.START_DISCOUNT;
import static christmas.model.event.EventMsg.CHRISTMAS_DDAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.reservation.date.Date;

public class ChristmasDdayEvent extends Event {
    public ChristmasDdayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && isBetweenDate();
    }

    private boolean isBetweenDate() {
        return date.date() >= START_DATE && date.date() <= END_DATE;
    }

    @Override
    public void applyBenefit(int date) {
        if (!canDiscount()) {
            return;
        }

        this.discount = START_DISCOUNT +
                DISCOUNT_UNIT * (date - 1);
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(CHRISTMAS_DDAY_EVENT_MSG.toString(), COMMA_FORMATTER.format(this.discount));
    }
}
