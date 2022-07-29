package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper from rms request object to nouvelair request object
 */
@Mapper
public interface RMSToNouvelairRequestMapper {

    @Mapping(source = "origin", target = "from")
    @Mapping(source = "destination", target = "to")
    @Mapping(source = "departureDate", target = "outboundDate")
    @Mapping(source = "returnDate", target = "inboundDate")
    @Mapping(source = "numberOfPassengers", target = "numberOfAdults")
    NouvelairRequest entityToResponseMapper(RmsFlightsRequest rmsFlightsRequest);
}
