package christmas.model.event;

import static christmas.Config.MIN_AMOUNT_DUE_FOR_EVENT;

public abstract class Event {
    protected final int amountDue;

    public Event(int amountDue) {
        this.amountDue = amountDue;
    }

    public boolean isFitCondition() {
        return this.amountDue >= MIN_AMOUNT_DUE_FOR_EVENT;
    }

    public abstract void applyBenefit();
}
