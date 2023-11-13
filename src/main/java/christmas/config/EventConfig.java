package christmas.config;

import java.text.DecimalFormat;

public class EventConfig {
    public static final int MIN_AMOUNT_DUE_FOR_EVENT = 10_000;
    public static final DecimalFormat COMMA_FORMATTER = new DecimalFormat("###,###");

    public static class ConfigChristmasDdayEvent {
        public static final int START_DATE = 1;
        public static final int END_DATE = 25;
        public static final int START_DISCOUNT = 1_000;
        public static final int DISCOUNT_UNIT = 100;
    }
}
