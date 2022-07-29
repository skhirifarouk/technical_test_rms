package com.tech.interview.rmsflights.util.mapper.response;


import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Mapper from nouvelair response object to rms response object
 */
@Mapper
public interface NouvelairToRMSResponseMapper {

    @Mapping(source = "carrier", target = "airline")
    @Mapping(source = "departureAirportName", target = "departureAirportCode")
    @Mapping(source = "destinationAirportName", target = "destinationAirportCode")
    @Mapping(source = "outboundDateTime", target = "departureDate")
    @Mapping(source = "inboundDateTime", target = "arrivalDate")
    @Mapping(source = ".", target = "fare", qualifiedByName = "computeFare")
    RmsFlightsResponse entityToResponseMapper(NouvelairResponse tunisairResponse);

    @Named("computeFare")
    public static BigDecimal computeFare(NouvelairResponse response) {
        return BigDecimal.valueOf((response.getBasePrice() * response.getDiscount() / 100) + response.getTax()).setScale(2, RoundingMode.HALF_EVEN);
    }
}
