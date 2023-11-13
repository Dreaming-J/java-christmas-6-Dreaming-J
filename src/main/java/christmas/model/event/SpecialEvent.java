package christmas.model.event;

import static christmas.config.EventConfig.SPECIAL_EVENT_DISCOUNT;
import static christmas.model.event.EventMsg.SPECIAL_EVENT_MSG;
import static christmas.util.Constant.COMMA_FORMATTER;
import static christmas.util.Constant.EMPTY;

import christmas.model.date.Date;

public class SpecialEvent extends Event {
    public SpecialEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.hasStar();
    }

    @Override
    public void applyBenefit(int date) {
        if (!canDiscount()) {
            return;
        }

        this.discount = SPECIAL_EVENT_DISCOUNT;
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(SPECIAL_EVENT_MSG.toString(), COMMA_FORMATTER.format(this.discount));
    }
}
