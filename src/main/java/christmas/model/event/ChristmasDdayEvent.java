package christmas.model.event;

import static christmas.config.EventConfig.ConfigChristmasDdayEvent.CHRISTMAS_EVENT_DISCOUNT_UNIT;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.END_DATE;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.START_DATE;
import static christmas.config.EventConfig.ConfigChristmasDdayEvent.START_DISCOUNT;
import static christmas.model.event.EventMsg.CHRISTMAS_DDAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.Money;
import christmas.model.date.Date;

public class ChristmasDdayEvent extends Event {
    public ChristmasDdayEvent(Date date, Money amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && isBetweenDate();
    }

    private boolean isBetweenDate() {
        return date.date() >= START_DATE && date.date() <= END_DATE;
    }

    @Override
    public void applyBenefit(int date) {
        if (!canDiscount()) {
            return;
        }

        Money standardDiscount = new Money(START_DISCOUNT);
        Money additionalDiscount = new Money(CHRISTMAS_EVENT_DISCOUNT_UNIT).multiply(date - 1);
        this.discount = standardDiscount.plus(additionalDiscount)
                .signConvert();
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(CHRISTMAS_DDAY_EVENT_MSG.toString(), discount);
    }
}
