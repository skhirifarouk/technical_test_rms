package com.tech.interview.rmsflights.util.mapper.response;


import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Mapper from tunisair response object to rms response object
 */
@Mapper
public interface TunisairToRMSResponseMapper {

    @Mapping(source = "airline", target = "airline")
    @Mapping(source = "departureAirportCode", target = "departureAirportCode")
    @Mapping(source = "destinationAirportCode", target = "destinationAirportCode")
    @Mapping(source = "departureDate", target = "departureDate")
    @Mapping(source = "departureDate", target = "arrivalDate")
    @Mapping(source = "price", target = "fare", qualifiedByName = "computeFare")
    RmsFlightsResponse entityToResponseMapper(TunisairResponse tunisairResponse);

    @Named("computeFare")
    public static BigDecimal computeFare(double price) {
        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_EVEN);
    }
}
