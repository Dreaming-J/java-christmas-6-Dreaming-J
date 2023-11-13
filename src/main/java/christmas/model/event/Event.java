package christmas.model.event;

import static christmas.config.EventConfig.MIN_AMOUNT_DUE_FOR_EVENT;

import christmas.model.Money;
import christmas.model.date.Date;

public abstract class Event {
    protected final Date date;
    protected final Money amountDue;
    protected Money discount;

    public Event(Date date, Money amountDue) {
        this.date = date;
        this.amountDue = amountDue;
        this.discount = new Money(0);
    }

    public boolean canDiscount() {
        return amountDue.isMore(MIN_AMOUNT_DUE_FOR_EVENT);
    }

    protected boolean doesNotExistDiscount() {
        return discount.isZero();
    }

    public abstract void applyBenefit(int applicableTarget);
}
