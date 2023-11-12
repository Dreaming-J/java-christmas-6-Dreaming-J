package christmas.model.event;

import christmas.model.reservation.date.Date;

public class ChristmasDdayEvent extends Event {
    private final Date date;

    public ChristmasDdayEvent(int amountDue, Date date) {
        super(amountDue);
        this.date = date;
    }

    @Override
    public boolean isFitCondition() {
        return super.isFitCondition();
    }

    @Override
    public void applyBenefit() {

    }
}
