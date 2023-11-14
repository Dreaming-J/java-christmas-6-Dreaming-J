package christmas.dto;

import static christmas.config.OrderConfig.ORDER_STRING_FORMAT;
import static christmas.util.Constant.NOTHING;

import christmas.model.menu.Menu;
import christmas.model.order.Quantity;
import java.util.Objects;

public class Giveaway {
    private final Menu menu;
    private final Quantity quantity;

    public Giveaway(Menu menu, Quantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Giveaway() {
        this.menu = null;
        this.quantity = null;
    }

    public Menu getMenu() {
        return this.menu;
    }

    @Override
    public String toString() {
        if (Objects.isNull(menu)) {
            return NOTHING;
        }
        return String.format(ORDER_STRING_FORMAT, menu, quantity);
    }
}
