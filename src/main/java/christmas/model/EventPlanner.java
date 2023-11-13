package christmas.model;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.util.Constant.NOTHING;

import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.event.subEvent.ChristmasDdayEvent;
import christmas.model.event.subEvent.GiveawayEvent;
import christmas.model.event.subEvent.SpecialEvent;
import christmas.model.event.subEvent.WeekdayEvent;
import christmas.model.event.subEvent.WeekendEvent;
import christmas.model.order.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    private final List<Event> events;

    public EventPlanner(Date date, Order order) {
        events = init(date, order);
        events.forEach(Event::applyBenefit);
    }

    private List<Event> init(Date date, Order order) {
        List<Event> events = new ArrayList<>();
        events.add(new ChristmasDdayEvent(date, order));
        events.add(new WeekdayEvent(date, order));
        events.add(new WeekendEvent(date, order));
        events.add(new SpecialEvent(date, order));
        events.add(new GiveawayEvent(date, order));
        return events.stream()
                .filter(Event::canDiscount)
                .toList();
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
