package com.tech.interview.rmsflights.util.mapper.response;

import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T19:01:12+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
public class TunisairToRMSResponseMapperImpl implements TunisairToRMSResponseMapper {

    @Override
    public RmsFlightsResponse entityToResponseMapper(TunisairResponse tunisairResponse) {
        if ( tunisairResponse == null ) {
            return null;
        }

        RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();

        rmsFlightsResponse.setAirline( tunisairResponse.getAirline() );
        rmsFlightsResponse.setDepartureAirportCode( tunisairResponse.getDepartureAirportCode() );
        rmsFlightsResponse.setDestinationAirportCode( tunisairResponse.getDestinationAirportCode() );
        rmsFlightsResponse.setDepartureDate( tunisairResponse.getDepartureDate() );
        rmsFlightsResponse.setArrivalDate( tunisairResponse.getDepartureDate() );
        rmsFlightsResponse.setFare( TunisairToRMSResponseMapper.computeFare( tunisairResponse.getPrice() ) );

        return rmsFlightsResponse;
    }
}
