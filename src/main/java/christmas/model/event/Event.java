package christmas.model.event;

import static christmas.config.EventConfig.MIN_AMOUNT_DUE_FOR_EVENT;

import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.order.Order;

public abstract class Event {
    protected final Date date;
    protected final Order order;
    protected Money discount;

    public Event(Date date, Order order) {
        this.date = date;
        this.order = order;
        this.discount = new Money(0);
    }

    public boolean canDiscount() {
        return order.amountDue()
                .isMore(MIN_AMOUNT_DUE_FOR_EVENT);
    }

    public Money getDiscount() {
        return discount;
    }

    protected boolean doesNotExistDiscount() {
        return discount.isZero();
    }

    public abstract void applyBenefit();
}
