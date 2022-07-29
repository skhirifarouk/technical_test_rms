package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.tunisair.TunisAirRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper from rms request object to tunisair request object
 */
@Mapper
public interface RMSToTunisairRequestMapper {

    @Mapping(source = "origin", target = "origin")
    @Mapping(source = "destination", target = "destination")
    @Mapping(source = "departureDate", target = "departureDate")
    @Mapping(source = "returnDate", target = "returnDate")
    @Mapping(source = "numberOfPassengers", target = "passengerCount")
    TunisAirRequest entityToResponseMapper(RmsFlightsRequest rmsFlightsRequest);
}
