package christmas.model.event;

import static christmas.config.EventConfig.WEEKEND_EVENT_DISCOUNT_UNIT;
import static christmas.model.event.EventMsg.WEEKEND_EVENT_MSG;
import static christmas.util.Constant.COMMA_FORMATTER;
import static christmas.util.Constant.EMPTY;

import christmas.model.date.Date;

public class WeekendEvent extends Event {
    public WeekendEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.isWeekend();
    }

    @Override
    public void applyBenefit(int quantityOfMains) {
        if (!canDiscount()) {
            return;
        }

        this.discount = quantityOfMains * WEEKEND_EVENT_DISCOUNT_UNIT;
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(WEEKEND_EVENT_MSG.toString(), COMMA_FORMATTER.format(this.discount));
    }
}
