package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T19:01:12+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
public class RMSToNouvelairRequestMapperImpl implements RMSToNouvelairRequestMapper {

    @Override
    public NouvelairRequest entityToResponseMapper(RmsFlightsRequest rmsFlightsRequest) {
        if ( rmsFlightsRequest == null ) {
            return null;
        }

        NouvelairRequest nouvelairRequest = new NouvelairRequest();

        nouvelairRequest.setFrom( rmsFlightsRequest.getOrigin() );
        nouvelairRequest.setTo( rmsFlightsRequest.getDestination() );
        nouvelairRequest.setOutboundDate( rmsFlightsRequest.getDepartureDate() );
        nouvelairRequest.setInboundDate( rmsFlightsRequest.getReturnDate() );
        nouvelairRequest.setNumberOfAdults( rmsFlightsRequest.getNumberOfPassengers() );

        return nouvelairRequest;
    }
}
