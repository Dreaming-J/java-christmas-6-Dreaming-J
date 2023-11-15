package christmas.util;

import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.event.EventEnum;
import christmas.model.event.subEvent.ChristmasDdayEvent;
import christmas.model.event.subEvent.GiveawayEvent;
import christmas.model.event.subEvent.SpecialEvent;
import christmas.model.event.subEvent.WeekdayEvent;
import christmas.model.event.subEvent.WeekendEvent;
import christmas.model.order.Order;
import java.util.EnumMap;
import java.util.Map;

public class EventMapGenerator {
    public static Map<EventEnum, Event> init(Date date, Order order) {
        Map<EventEnum, Event> events = new EnumMap<>(EventEnum.class);
        putEvents(events, date, order);
        filterEvents(events);
        return events;
    }

    private static void putEvents(Map<EventEnum, Event> events, Date date, Order order) {
        events.put(EventEnum.CHRISTMAS_DDAY, new ChristmasDdayEvent(date, order));
        events.put(EventEnum.WEEKDAY, new WeekdayEvent(date, order));
        events.put(EventEnum.WEEKEND, new WeekendEvent(date, order));
        events.put(EventEnum.SPECIAL, new SpecialEvent(date, order));
        events.put(EventEnum.GIVEAWAY, new GiveawayEvent(date, order));
    }

    private static void filterEvents(Map<EventEnum, Event> events) {
        events.keySet()
                .stream()
                .filter(eventEnum -> !events.get(eventEnum)
                        .canDiscount())
                .forEach(events::remove);
    }
}
