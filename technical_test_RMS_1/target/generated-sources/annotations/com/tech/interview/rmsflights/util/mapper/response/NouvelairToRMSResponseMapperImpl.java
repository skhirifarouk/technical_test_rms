package com.tech.interview.rmsflights.util.mapper.response;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T19:01:12+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
public class NouvelairToRMSResponseMapperImpl implements NouvelairToRMSResponseMapper {

    @Override
    public RmsFlightsResponse entityToResponseMapper(NouvelairResponse tunisairResponse) {
        if ( tunisairResponse == null ) {
            return null;
        }

        RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();

        rmsFlightsResponse.setAirline( tunisairResponse.getCarrier() );
        rmsFlightsResponse.setDepartureAirportCode( tunisairResponse.getDepartureAirportName() );
        rmsFlightsResponse.setDestinationAirportCode( tunisairResponse.getDestinationAirportName() );
        rmsFlightsResponse.setDepartureDate( tunisairResponse.getOutboundDateTime() );
        rmsFlightsResponse.setArrivalDate( tunisairResponse.getInboundDateTime() );
        rmsFlightsResponse.setFare( NouvelairToRMSResponseMapper.computeFare( tunisairResponse ) );

        return rmsFlightsResponse;
    }
}
