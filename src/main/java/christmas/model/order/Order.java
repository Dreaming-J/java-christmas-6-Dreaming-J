package christmas.model.order;

import static christmas.config.OrderConfig.ORDER_REGEX;
import static christmas.config.OrderConfig.ORDER_STRING_FORMAT;
import static christmas.model.order.OrderMapGenerator.createOrderMap;
import static christmas.util.Constant.LINE_BREAK;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return this.order.keySet()
                .stream()
                .map(menu -> String.format(ORDER_STRING_FORMAT, menu.getFood(), order.get(menu).number()))
                .collect(Collectors.joining(LINE_BREAK));
    }
}
