package christmas.util;

import christmas.exception.Exception.OrderException;

public class TypeConverter {

    private static final String ERROR_MSG_CONVERT_TO_INT = "숫자만 입력해주세요.";

    public static int toIntForDate(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new OrderException();
        }
    }

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_CONVERT_TO_INT);
        }
    }
}
