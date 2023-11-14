package christmas.model;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.util.Constant.NOTHING;
import static christmas.util.EventListGenerator.init;

import christmas.dto.Giveaway;
import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.event.subEvent.GiveawayEvent;
import christmas.model.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    private final List<Event> events;

    public EventPlanner(Date date, Order order) {
        events = init(date, order);
        events.forEach(Event::applyBenefit);
    }

    public Money totalDiscountWithGiveaway() {
        return events.stream()
                .map(Event::getDiscount)
                .reduce(Money::plus)
                .orElse(Money.ZERO());
    }

    public Money totalDiscountWithoutGiveaway() {
        return events.stream()
                .filter(Event::isDiscountEvent)
                .map(Event::getDiscount)
                .reduce(Money::plus)
                .orElse(Money.ZERO());
    }

    public Giveaway getGiveaway() {
        if (hasNotGiveawayEvent()) {
            return new Giveaway();
        }

        return events.stream()
                .filter(Event::isGiveawayEvent)
                .findFirst()
                .map(event -> (GiveawayEvent) event)
                .get()
                .getGiveaway();
    }

    private boolean hasNotGiveawayEvent() {
        return events.stream()
                .noneMatch(Event::isGiveawayEvent);
    }

    public Badge createBadge() {
        return Badge.from(totalDiscountWithGiveaway().signConvert());
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
