package christmas.model.event.subEvent;

import static christmas.config.EventConfig.WEEKEND_EVENT_DISCOUNT_UNIT;
import static christmas.model.event.EventMsg.WEEKEND_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;

public class WeekendEvent extends Event {
    public WeekendEvent(Date date, Order order) {
        super(date, order);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.isWeekend();
    }

    @Override
    public boolean isDiscountEvent() {
        return true;
    }

    @Override
    public void applyBenefit() {
        int quantityOfMains = order.countMain();
        discount = new Money(WEEKEND_EVENT_DISCOUNT_UNIT).multiply(quantityOfMains)
                .signConvert();
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(WEEKEND_EVENT_MSG.toString(), discount);
    }
}
