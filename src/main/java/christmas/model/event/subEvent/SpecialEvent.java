package christmas.model.event.subEvent;

import static christmas.config.EventConfig.SPECIAL_EVENT_DISCOUNT;
import static christmas.model.event.EventMsg.SPECIAL_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;

public class SpecialEvent extends Event {
    public SpecialEvent(Date date, Order order) {
        super(date, order);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.hasStar();
    }

    @Override
    public boolean isDiscountEvent() {
        return true;
    }

    @Override
    public void applyBenefit() {
        if (!canDiscount()) {
            return;
        }

        discount = new Money(SPECIAL_EVENT_DISCOUNT).signConvert();
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(SPECIAL_EVENT_MSG.toString(), discount);
    }
}
