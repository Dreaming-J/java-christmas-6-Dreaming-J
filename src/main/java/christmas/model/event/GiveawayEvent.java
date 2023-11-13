package christmas.model.event;

import static christmas.config.EventConfig.SPECIAL_EVENT_THRESHOLD_AMOUNT_DUE;

import christmas.model.date.Date;

public class GiveawayEvent extends Event {

    public GiveawayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && isOverThreshold();
    }

    private boolean isOverThreshold() {
        return amountDue >= SPECIAL_EVENT_THRESHOLD_AMOUNT_DUE;
    }

    @Override
    public void applyBenefit(int applicableTarget) {

    }
}
