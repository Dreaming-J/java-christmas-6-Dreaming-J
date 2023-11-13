package christmas.config;

import java.text.DecimalFormat;

public class EventConfig {
    public static final int MIN_AMOUNT_DUE_FOR_EVENT = 10_000;
    public static final DecimalFormat COMMA_FORMATTER = new DecimalFormat("###,###");

    public static class ConfigChristmasDdayEvent {
        public static final int START_DATE = 1;
        public static final int END_DATE = 25;
        public static final int START_DISCOUNT = 1_000;
        public static final int CHRISTMAS_EVENT_DISCOUNT_UNIT = 100;
    }

    public static final int WEEKDAY_EVENT_DISCOUNT_UNIT = 2_023;
    public static final int WEEKEND_EVENT_DISCOUNT_UNIT = 2_023;
    public static final int WEEK_EVENT_DISCOUNT = 1_000;
    public static final int SPECIAL_EVENT_THRESHOLD_AMOUNT_DUE = 120_000;
}
