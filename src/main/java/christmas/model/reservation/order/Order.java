package christmas.model.reservation.order;

import static christmas.Config.ORDER_REGEX;
import static christmas.model.reservation.order.OrderMapGenerator.createOrderMap;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import java.util.Map;
import java.util.regex.Pattern;

public class Order {
    private final Map<Menu, Quantity> order;

    public Order(String orders) {
        validateRegex(orders);
        this.order = createOrderMap(orders);
    }

    private void validateRegex(String orders) {
        if (isNotRegex(orders)) {
            throw new OrderException();
        }
    }

    private boolean isNotRegex(String orders) {
        return !Pattern.matches(ORDER_REGEX, orders);
    }

    public int amountDue() {
        return this.order.keySet()
                .stream()
                .mapToInt(menu -> menu.getPrice() * getQuantity(menu))
                .sum();
    }

    private int getQuantity(Menu menu) {
        return this.order.get(menu)
                .number();
    }

    public int countDessert() {
        return this.order.keySet()
                .stream()
                .filter(Menu::isDessert)
                .mapToInt(this::getQuantity)
                .sum();
    }

    public int countMain() {
        return this.order.keySet()
                .stream()
                .filter(Menu::isMain)
                .mapToInt(this::getQuantity)
                .sum();
    }
}
