package christmas;

public class Config {
    public static final String ORDER_REGEX = "^([가-힣]+)-(\\d+)(,([가-힣]+)-(\\d+))*$";

    public static final int MIN_QUNTITY = 1;
    public static final int MAX_TOTAL_QUANTITY = 20;

    public static final int MIN_AMOUNT_DUE_FOR_EVENT = 10_000;

    public static class ConfigChristmasDdayEvent {
        public static final int START_DATE = 1;
        public static final int END_DATE = 25;
    }
}
