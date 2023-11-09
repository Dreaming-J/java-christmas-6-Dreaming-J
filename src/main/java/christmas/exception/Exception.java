package christmas.exception;

public class Exception {
    public static class OrderException extends IllegalArgumentException {
        public OrderException() {
            super("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
