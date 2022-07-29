package com.tech.interview.tunisairflights.util.mapper;

import com.tech.interview.tunisairflights.domain.TunisairResponse;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import java.text.SimpleDateFormat;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T19:00:24+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
public class EntityResponseMapperImpl implements EntityResponseMapper {

    @Override
    public TunisairResponse entityToResponseMapper(TunisairFlight tunisAirFlight) {
        if ( tunisAirFlight == null ) {
            return null;
        }

        TunisairResponse tunisairResponse = new TunisairResponse();

        tunisairResponse.setAirline( tunisAirFlight.getAirline() );
        tunisairResponse.setPrice( tunisAirFlight.getPrice() );
        tunisairResponse.setCabinclass( tunisAirFlight.getCabinclass() );
        tunisairResponse.setDepartureAirportCode( tunisAirFlight.getDepartureAirportCode() );
        tunisairResponse.setDestinationAirportCode( tunisAirFlight.getDestinationAirportCode() );
        if ( tunisAirFlight.getDepartureDate() != null ) {
            tunisairResponse.setDepartureDate( new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" ).format( tunisAirFlight.getDepartureDate() ) );
        }
        if ( tunisAirFlight.getArrivalDate() != null ) {
            tunisairResponse.setArrivalDate( new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" ).format( tunisAirFlight.getArrivalDate() ) );
        }

        return tunisairResponse;
    }
}
