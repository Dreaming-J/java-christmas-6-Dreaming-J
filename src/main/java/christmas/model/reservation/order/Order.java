package christmas.model.reservation.order;

import static christmas.Config.ORDER_REGEX;
import static christmas.util.Constant.COMMA;
import static christmas.util.Constant.DASH;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import christmas.util.TypeConverter;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
    private final Map<Menu, Quantity> order;

    public Order(String orders) {
        validate(orders);
        this.order = Stream.of(orders.split(COMMA))
                .map(order -> order.split(DASH))
                .collect(Collectors
                        .toMap(order -> Menu.from(order[0]),
                                order -> new Quantity(TypeConverter.toInt(order[1])),
                                (oldMenu, newMenu) -> {
                                    throw new OrderException();
                                },
                                () -> new EnumMap<>(Menu.class)));
    }

    private void validate(String orders) {
        if (isNotRegex(orders)) {
            throw new OrderException();
        }
    }

    private boolean isNotRegex(String orders) {
        return !Pattern.matches(ORDER_REGEX, orders);
    }
}
