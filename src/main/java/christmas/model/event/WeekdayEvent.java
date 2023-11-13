package christmas.model.event;

import static christmas.config.EventConfig.COMMA_FORMATTER;
import static christmas.config.EventConfig.WEEKDAY_EVENT_DISCOUNT_UNIT;
import static christmas.model.event.EventMsg.WEEKDAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.date.Date;

public class WeekdayEvent extends Event {
    public WeekdayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.isWeekday();
    }

    @Override
    public void applyBenefit(int quantityOfDesserts) {
        if (!canDiscount()) {
            return;
        }

        this.discount = quantityOfDesserts * WEEKDAY_EVENT_DISCOUNT_UNIT;
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(WEEKDAY_EVENT_MSG.toString(), COMMA_FORMATTER.format(this.discount));
    }
}
