package christmas.model.order;

import static christmas.config.OrderConfig.ORDER_STRING_FORMAT;
import static christmas.model.order.OrderMapGenerator.createOrderMap;
import static christmas.util.Constant.LINE_BREAK;

import christmas.model.Money;
import christmas.model.menu.Menu;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<Menu, Quantity> order;

    public Order(String orders) {
        this.order = createOrderMap(orders);
    }

    public Money amountDue() {
        return this.order.keySet()
                .stream()
                .map(menu -> menu.getPrice()
                        .multiply(getQuantity(menu)))
                .reduce(Money::plus)
                .get();
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
                .map(menu -> String.format(ORDER_STRING_FORMAT, menu, order.get(menu)))
                .collect(Collectors.joining(LINE_BREAK));
    }
}
