package christmas.model.event;

import christmas.model.reservation.date.Date;

public class WeekendEvent extends Event {
    public WeekendEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.isWeekend();
    }

    @Override
    public void applyBenefit(int applicableTarget) {

    }
}
