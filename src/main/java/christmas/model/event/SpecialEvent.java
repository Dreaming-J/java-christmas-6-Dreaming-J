package christmas.model.event;

import christmas.model.reservation.date.Date;

public class SpecialEvent extends Event {

    public SpecialEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && date.hasStar();
    }

    @Override
    public void applyBenefit(int date) {

    }
}
