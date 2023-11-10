package christmas.exception;

public class Exception {

    private static final String ERROR_MSG_ORDER_EXCEPTION = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ERROR_MSG_DATE_EXCEPTION = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static class OrderException extends IllegalArgumentException {
        public OrderException() {
            super(ERROR_MSG_ORDER_EXCEPTION);
        }
    }

    public static class DateException extends IllegalArgumentException {
        public DateException() {
            super(ERROR_MSG_DATE_EXCEPTION);
        }
    }
}
