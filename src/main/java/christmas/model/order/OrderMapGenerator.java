package christmas.model.order;

import static christmas.config.OrderConfig.MAX_TOTAL_QUANTITY;
import static christmas.util.Constant.COMMA;
import static christmas.util.Constant.DASH;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import christmas.util.TypeConverter;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderMapGenerator {
    public static Map<Menu, Quantity> createOrderMap(String orders) {
        Map<Menu, Quantity> orderMap = Stream.of(orders.split(COMMA))
                .map(order -> order.split(DASH))
                .collect(Collectors
                        .toMap(order -> Menu.from(order[0]),
                                order -> new Quantity(TypeConverter.toInt(order[1])),
                                (oldMenu, newMenu) -> {
                                    throw new OrderException();
                                },
                                () -> new EnumMap<>(Menu.class)));
        validateOrderMap(orderMap);
        return orderMap;
    }

    private static void validateOrderMap(Map<Menu, Quantity> orderMap) {
        Stream<Menu> orderMenus = orderMap.keySet().stream();
        Stream<Quantity> orderQuantities = orderMap.values().stream();

        if (isOnlyDrink(orderMenus) || isOverMaxTotalQuantity(orderQuantities)) {
            throw new OrderException();
        }
    }

    private static boolean isOnlyDrink(Stream<Menu> orderMenus) {
        return orderMenus.allMatch(Menu::isDrink);
    }

    private static boolean isOverMaxTotalQuantity(Stream<Quantity> orderQuantities) {
        return orderQuantities.mapToInt(Quantity::number)
                .sum() > MAX_TOTAL_QUANTITY;
    }
}
