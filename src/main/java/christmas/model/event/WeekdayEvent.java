package christmas.model.event;

import christmas.model.reservation.date.Date;

public class WeekdayEvent extends Event {
    public WeekdayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    protected boolean canDiscount() {
        return super.canDiscount() && date.isWeekday();
    }

    @Override
    public void applyBenefit(int applicableTarget) {
    public void applyBenefit(int quantityOfDesserts) {

    }
}
