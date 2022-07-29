package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.tunisair.TunisAirRequest;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T19:01:12+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
public class RMSToTunisairRequestMapperImpl implements RMSToTunisairRequestMapper {

    @Override
    public TunisAirRequest entityToResponseMapper(RmsFlightsRequest rmsFlightsRequest) {
        if ( rmsFlightsRequest == null ) {
            return null;
        }

        TunisAirRequest tunisAirRequest = new TunisAirRequest();

        tunisAirRequest.setOrigin( rmsFlightsRequest.getOrigin() );
        tunisAirRequest.setDestination( rmsFlightsRequest.getDestination() );
        tunisAirRequest.setDepartureDate( rmsFlightsRequest.getDepartureDate() );
        tunisAirRequest.setReturnDate( rmsFlightsRequest.getReturnDate() );
        tunisAirRequest.setPassengerCount( rmsFlightsRequest.getNumberOfPassengers() );

        return tunisAirRequest;
    }
}
