package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.Message.READ_DATE_MSG;
import static christmas.view.Message.READ_ORDER_MSG;

import christmas.util.TypeConverter;

public class InputView {
    public int readDate() {
        System.out.println(READ_DATE_MSG);
        return TypeConverter.toIntForDate(readLine());
    }

    public String readOrder() {
        System.out.println(READ_ORDER_MSG);
        return readLine();
    }
}
