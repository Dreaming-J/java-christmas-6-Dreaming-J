package christmas.model.reservation.order;

import static christmas.Config.ORDER_REGEX;

import christmas.exception.Exception.OrderException;
import java.util.regex.Pattern;

public class Order {
    public Order(String orders) {
        validate(orders);
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
