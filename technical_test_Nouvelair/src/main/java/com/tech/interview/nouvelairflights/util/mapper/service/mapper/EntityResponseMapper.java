package com.tech.interview.nouvelairflights.util.mapper.service.mapper;

import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper from entity to response
 */
@Mapper
public interface EntityResponseMapper {
    @Mapping(source = "airline", target = "airline")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "cabinclass", target = "cabinclass")
    @Mapping(source = "departureAirportCode", target = "departureAirportCode")
    @Mapping(source = "destinationAirportCode", target = "destinationAirportCode")
    @Mapping(source = "departureDate", target = "departureDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Mapping(source = "arrivalDate", target = "arrivalDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    NouvelairResponse entityToResponseMapper(NouvelairFlight nouvelairFlight);
}
