package christmas.model;

import static christmas.util.Constant.SIGN_CONVERTER;

import java.text.DecimalFormat;

public record Money(int money) {
    private static final DecimalFormat COMMA_FORMATTER = new DecimalFormat("###,###원;-###,###원");

    public Money plus(Money money) {
        return new Money(money.plus(this.money));
    }

    private int plus(int money) {
        return this.money + money;
    }

    public Money multiply(int count) {
        return new Money(this.money * count);
    }

    public Money signConvert() {
        return multiply(SIGN_CONVERTER);
    }

    public boolean isMore(int value) {
        return this.money >= value;
    }

    public boolean isZero() {
        return this.money == 0;
    }

    @Override
    public String toString() {
        return COMMA_FORMATTER.format(this.money);
    }
}
