package christmas.model.event.subEvent;

import static christmas.config.EventConfig.WEEKDAY_EVENT_DISCOUNT_UNIT;
import static christmas.model.event.EventMsg.WEEKDAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;

public class WeekdayEvent extends Event {
    public WeekdayEvent(Date date, Order order) {
        super(date, order);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.isWeekday();
    }

    @Override
    public boolean isDiscountEvent() {
        return true;
    }

    @Override
    public void applyBenefit() {
        int quantityOfDesserts = order.countDessert();
        discount = new Money(WEEKDAY_EVENT_DISCOUNT_UNIT).multiply(quantityOfDesserts)
                .signConvert();
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(WEEKDAY_EVENT_MSG.toString(), discount);
    }
}
