package christmas.util;

import static christmas.config.OrderConfig.MAX_TOTAL_QUANTITY;
import static christmas.config.OrderConfig.ORDER_REGEX;
import static christmas.util.Constant.COMMA;
import static christmas.util.Constant.DASH;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import christmas.model.order.Quantity;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class OrderMapGenerator {
    public static Map<Menu, Quantity> createOrderMap(String orders) {
        validateRegex(orders);
        List<List<String>> orderKVP = createOrderKVP(orders);
        Map<Menu, Quantity> orderMap = createOrderMap(orderKVP);
        validateOrderMap(orderMap);
        return orderMap;
    }

    private static void validateRegex(String orders) {
        if (isNotRegex(orders)) {
            throw new OrderException();
        }
    }

    private static boolean isNotRegex(String orders) {
        return !Pattern.matches(ORDER_REGEX, orders);
    }

    private static List<List<String>> createOrderKVP(String orders) {
        return Stream.of(orders.split(COMMA))
                .map(order -> Stream.of(order.split(DASH))
                        .toList())
                .toList();
    }

    private static Map<Menu, Quantity> createOrderMap(List<List<String>> orderKVP) {
        Map<Menu, Quantity> orderMap = new EnumMap<>(Menu.class);

        for (List<String> pair : orderKVP) {
            if (orderMap.containsKey(Menu.from(pair.get(0)))) {
                throw new OrderException();
            }

            orderMap.put(Menu.from(pair.get(0)),
                    new Quantity(TypeConverter.toInt(pair.get(1))));
        }

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
