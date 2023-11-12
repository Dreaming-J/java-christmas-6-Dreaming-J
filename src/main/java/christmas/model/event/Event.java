package christmas.model.event;

public abstract class Event {
    protected final int amountDue;

    public Event(int amountDue) {
        this.amountDue = amountDue;
    }

    public boolean isFitCondition() {
        return false;
    }

    public abstract void applyBenefit();
}
