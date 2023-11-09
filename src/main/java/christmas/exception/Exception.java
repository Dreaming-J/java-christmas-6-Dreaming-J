package christmas.exception;

public class Exception {
    public static class OrderException extends IllegalArgumentException {
        public OrderException() {
            super("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static class DateException extends IllegalArgumentException {
        public DateException() {
            super("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
