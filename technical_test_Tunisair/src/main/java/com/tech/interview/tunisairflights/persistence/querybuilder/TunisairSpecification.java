package com.tech.interview.tunisairflights.persistence.querybuilder;

import com.tech.interview.tunisairflights.model.TunisairFlight;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Query specifications
 */
public class TunisairSpecification {

    /**
     * Origin countains text
     * @param expression
     * @return
     */
    public static Specification<TunisairFlight> originContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("departureAirportCode"), expression);
    }

    /**
     * Destination contains text
     * @param expression
     * @return
     */
    public static Specification<TunisairFlight> destinationContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("destinationAirportCode"), expression);
    }

    /**
     * Departure date from
     * @param expression
     * @return
     */
    public static Specification<TunisairFlight> departureDateFrom(String expression) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("departureDate"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Arrival date to
     * @param expression
     * @return
     */
    public static Specification<TunisairFlight> returnDateTo(String expression) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("arrivalDate"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Passenger count equals
     * @param expression
     * @return
     */
    public static Specification<TunisairFlight> passengerCountContains(int expression) {
        return (root, query, builder) -> builder.equal(root.get("passengerCount"), expression);
    }
}
