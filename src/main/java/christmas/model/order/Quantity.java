package christmas.model.order;

import static christmas.config.OrderConfig.MIN_QUNTITY;

import christmas.exception.Exception.OrderException;

public record Quantity(int number) {
    public Quantity {
        validate(number);
    }

    private void validate(int number) {
        if (isUnderMin(number)) {
            throw new OrderException();
        }
    }

    private boolean isUnderMin(int number) {
        return number < MIN_QUNTITY;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
