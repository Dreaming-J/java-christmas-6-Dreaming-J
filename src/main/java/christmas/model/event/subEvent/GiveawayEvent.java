package christmas.model.event.subEvent;

import static christmas.config.EventConfig.ConfigGiveawayEvent.GIVEAWAY_EVENT_THRESHOLD_AMOUNT_DUE;
import static christmas.config.EventConfig.ConfigGiveawayEvent.GIVEAWAY_MENU;
import static christmas.model.event.EventMsg.GIVEAWAY_EVENT_MSG;
import static christmas.util.Constant.EMPTY;

import christmas.dto.Giveaway;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.menu.Menu;
import christmas.model.order.Order;
import christmas.model.order.Quantity;

public class GiveawayEvent extends Event {
    private Giveaway giveaway;

    public GiveawayEvent(Date date, Order order) {
        super(date, order);
    }

    @Override
    public boolean canDiscount() {
        return super.canDiscount() && isOverThreshold();
    }

    private boolean isOverThreshold() {
        return order.amountDue()
                .isMore(GIVEAWAY_EVENT_THRESHOLD_AMOUNT_DUE);
    }

    @Override
    public boolean isGiveawayEvent() {
        return true;
    }

    @Override
    public void applyBenefit() {
        giveaway = new Giveaway(Menu.from(GIVEAWAY_MENU), new Quantity(1));
        this.discount = giveaway.getMenu()
                .getPrice()
                .signConvert();
    }

    public Giveaway getGiveaway() {
        return giveaway;
    }

    @Override
    public String toString() {
        if (doesNotExistDiscount()) {
            return EMPTY;
        }

        return String.format(GIVEAWAY_EVENT_MSG.toString(), discount);
    }
}
