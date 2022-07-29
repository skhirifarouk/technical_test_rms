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
    @Mapping(source = "carrier", target = "carrier")
    @Mapping(source = "basePrice", target = "basePrice")
    @Mapping(source = "tax", target = "tax")
    @Mapping(source = "discount", target = "discount")
    @Mapping(source = "departureAirportName", target = "departureAirportName")
    @Mapping(source = "destinationAirportName", target = "destinationAirportName")
    @Mapping(source = "outboundDateTime", target = "outboundDateTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Mapping(source = "inboundDateTime", target = "inboundDateTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    NouvelairResponse entityToResponseMapper(NouvelairFlight nouvelairFlight);
}
