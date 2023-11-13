package christmas.model.event;

import static christmas.config.EventConfig.COMMA_FORMATTER;
import static christmas.config.EventConfig.ConfigGiveawayEvent.GIVEAWAY_EVENT_THRESHOLD_AMOUNT_DUE;
import static christmas.config.EventConfig.ConfigGiveawayEvent.GIVEAWAY_MENU;
import static christmas.model.event.EventMsg.GIVEAWAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.model.date.Date;
import christmas.model.menu.Menu;

public class GiveawayEvent extends Event {

    public GiveawayEvent(Date date, int amountDue) {
        super(date, amountDue);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && isOverThreshold();
    }

    private boolean isOverThreshold() {
        return amountDue >= GIVEAWAY_EVENT_THRESHOLD_AMOUNT_DUE;
    }

    @Override
    public void applyBenefit(int dummy) {
        if (!canDiscount()) {
            return;
        }

        //TODO: 증정품 클래스로 분리하기
        Menu menu = Menu.from(GIVEAWAY_MENU);
        this.discount = menu.getPrice();
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(GIVEAWAY_EVENT_MSG.toString(), COMMA_FORMATTER.format(this.discount));
    }
}
