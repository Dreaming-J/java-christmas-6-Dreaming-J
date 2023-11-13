package christmas.model.event;

import static christmas.Config.MIN_AMOUNT_DUE_FOR_EVENT;

public abstract class Event {
    protected final int amountDue;
    protected int discount;

    public Event(int amountDue) {
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
