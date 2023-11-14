package christmas.module;

import static christmas.util.Constant.ERROR_PREFIX;
import static christmas.util.Constant.LINE_BREAK;

import java.util.function.Supplier;

public class RepeatModule {
    protected <T> T repeat(Supplier<T> inputReader) {
        while (true) {
            try {
                return inputReader.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage() + LINE_BREAK);
            }
        }
    }
}