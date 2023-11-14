package christmas.model;

import static christmas.model.event.EventListGenerator.init;
import static christmas.util.Constant.LINE_BREAK;
import static christmas.util.Constant.NOTHING;

import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    private final List<Event> events;

    public EventPlanner(Date date, Order order) {
        events = init(date, order);
        events.forEach(Event::applyBenefit);
    }

    public Money totalDiscount() {
        return events.stream()
                .map(Event::getDiscount)
                .reduce(Money::plus)
                .get();
    }

    @Override
    public String toString() {
        if (events.isEmpty()) {
            return NOTHING;
        }

        return events.stream()
                .map(Event::toString)
                .collect(Collectors.joining(LINE_BREAK));
    }
}
