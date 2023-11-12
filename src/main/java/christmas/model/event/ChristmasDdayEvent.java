package christmas.model.event;

import static christmas.Config.ConfigChristmasDdayEvent.END_DATE;
import static christmas.Config.ConfigChristmasDdayEvent.START_DATE;

import christmas.model.reservation.date.Date;

public class ChristmasDdayEvent extends Event {
    private final Date date;

    public ChristmasDdayEvent(int amountDue, Date date) {
        super(amountDue);
        this.date = date;
    }

    @Override
    public boolean isFitCondition() {
        return super.isFitCondition() && isBetweenDate();
    }

    private boolean isBetweenDate() {
        return date.date() >= START_DATE && date.date() <= END_DATE;
    }

    @Override
    public void applyBenefit() {

    }
}
