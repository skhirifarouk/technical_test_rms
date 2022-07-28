package com.tech.interview.nouvelairflights.persistence.querybuilder;

import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Query specifications
 */
public class NouvelairSpecification {

    /**
     * Origin countains text
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> originContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("departureAirportCode"), expression);
    }

    /**
     * Destination contains text
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> destinationContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("destinationAirportCode"), expression);
    }

    /**
     * Departure date from
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> departureDateFrom(String expression) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("departureDate"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Arrival date to
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> returnDateTo(String expression) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("arrivalDate"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Passenger count equals
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> passengerCountContains(int expression) {
        return (root, query, builder) -> builder.equal(root.get("passengerCount"), expression);
    }
}
