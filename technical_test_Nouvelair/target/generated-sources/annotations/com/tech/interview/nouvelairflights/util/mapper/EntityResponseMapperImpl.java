package com.tech.interview.nouvelairflights.util.mapper;

import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T18:58:25+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class EntityResponseMapperImpl implements EntityResponseMapper {

    @Override
    public NouvelairResponse entityToResponseMapper(NouvelairFlight nouvelairFlight) {
        if ( nouvelairFlight == null ) {
            return null;
        }

        NouvelairResponse nouvelairResponse = new NouvelairResponse();

        nouvelairResponse.setCarrier( nouvelairFlight.getCarrier() );
        nouvelairResponse.setBasePrice( nouvelairFlight.getBasePrice() );
        nouvelairResponse.setTax( nouvelairFlight.getTax() );
        nouvelairResponse.setDiscount( nouvelairFlight.getDiscount() );
        nouvelairResponse.setDepartureAirportName( nouvelairFlight.getDepartureAirportName() );
        nouvelairResponse.setDestinationAirportName( nouvelairFlight.getDestinationAirportName() );
        if ( nouvelairFlight.getOutboundDateTime() != null ) {
            nouvelairResponse.setOutboundDateTime( new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" ).format( nouvelairFlight.getOutboundDateTime() ) );
        }
        if ( nouvelairFlight.getInboundDateTime() != null ) {
            nouvelairResponse.setInboundDateTime( new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" ).format( nouvelairFlight.getInboundDateTime() ) );
        }

        return nouvelairResponse;
    }
}
