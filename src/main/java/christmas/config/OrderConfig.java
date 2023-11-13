package christmas.config;

public class OrderConfig {
    public static final String ORDER_REGEX = "^([가-힣]+)-(\\d+)(,([가-힣]+)-(\\d+))*$";
    public static final int MIN_QUNTITY = 1;
    public static final int MAX_TOTAL_QUANTITY = 20;
}
