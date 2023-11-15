package christmas.model;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.util.Constant.NOTHING;
import static christmas.util.EventMapGenerator.init;

import christmas.dto.Giveaway;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.event.EventEnum;
import christmas.model.order.Order;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventPlanner {
    private final Map<EventEnum, Event> events;

    public EventPlanner(Date date, Order order) {
        events = init(date, order);
        eventsValue().forEach(Event::applyBenefit);
    }

    private Stream<Event> eventsValue() {
        return events.values()
                .stream();
    }

    public Money totalDiscountWithGiveaway() {
        return eventsValue().map(Event::getDiscount)
                .reduce(Money::plus)
                .orElse(Money.ZERO());
    }

    public Money totalDiscountWithoutGiveaway() {
        return eventsValueOnlyDiscount().map(Event::getDiscount)
                .reduce(Money::plus)
                .orElse(Money.ZERO());
    }

    private Stream<Event> eventsValueOnlyDiscount() {
        return events.keySet()
                .stream()
                .filter(EventEnum::isDiscountEvent)
                .map(events::get);
    }

    public Giveaway getGiveaway() {
        return eventsValue().map(Event::getGiveaway)
                .filter(Giveaway::exists)
                .findFirst()
                .orElse(new Giveaway());
    }

    public Badge createBadge() {
        return Badge.from(totalDiscountWithGiveaway().signConvert());
    }

    @Override
    public String toString() {
        if (events.isEmpty()) {
            return NOTHING;
        }

        return eventsValue().map(Event::toString)
                .collect(Collectors.joining(LINE_BREAK));
    }
}
