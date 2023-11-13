package christmas.model.event;

import static christmas.Config.MIN_AMOUNT_DUE_FOR_EVENT;

import christmas.model.reservation.date.Date;

public abstract class Event {
    protected final Date date;
    protected final int amountDue;
    protected int discount;

    public Event(Date date, int amountDue) {
        this.date = date;
        this.amountDue = amountDue;
    }

    protected boolean isFitCondition() {
        return this.amountDue >= MIN_AMOUNT_DUE_FOR_EVENT;
    }

    protected boolean existsDiscount() {
        return this.discount != 0;
    }

    public abstract void applyBenefit(int applicableTarget);
}