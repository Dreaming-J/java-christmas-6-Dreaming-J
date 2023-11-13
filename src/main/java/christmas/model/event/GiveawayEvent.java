package christmas.model.event;

import christmas.model.date.Date;

public class GiveawayEvent extends Event {

    public GiveawayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount();
    }

    @Override
    public void applyBenefit(int applicableTarget) {

    }
}
