package christmas.model.event;

import christmas.model.date.Date;
import christmas.model.event.subEvent.ChristmasDdayEvent;
import christmas.model.event.subEvent.GiveawayEvent;
import christmas.model.event.subEvent.SpecialEvent;
import christmas.model.event.subEvent.WeekdayEvent;
import christmas.model.event.subEvent.WeekendEvent;
import christmas.model.order.Order;
import java.util.ArrayList;
import java.util.List;

public class EventListGenerator {
    public static List<Event> init(Date date, Order order) {
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
}
