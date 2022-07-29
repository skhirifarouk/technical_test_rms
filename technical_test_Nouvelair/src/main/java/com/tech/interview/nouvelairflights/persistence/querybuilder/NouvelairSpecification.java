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
    public static Specification<NouvelairFlight> departureContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("departureAirportName"), expression);
    }

    /**
     * Destination contains text
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> destinationContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("destinationAirportName"), expression);
    }

    /**
     * Departure date from
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> outboundDateFrom(String expression) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("outboundDateTime"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Arrival date to
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> inboundDateTo(String expression) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("inboundDateTime"), Date.from(LocalDate.parse(expression, DateTimeFormatter.ISO_LOCAL_DATE).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Passenger count equals
     * @param expression
     * @return
     */
    public static Specification<NouvelairFlight> numberOfAdultsLessOfEqual(int expression) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("numberOfAdults"), expression);
    }
}
