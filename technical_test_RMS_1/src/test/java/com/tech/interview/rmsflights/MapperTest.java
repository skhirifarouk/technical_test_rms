package com.tech.interview.rmsflights;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisAirRequest;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import com.tech.interview.rmsflights.util.mapper.request.RMSToNouvelairRequestMapper;
import com.tech.interview.rmsflights.util.mapper.request.RMSToTunisairRequestMapper;
import com.tech.interview.rmsflights.util.mapper.response.NouvelairToRMSResponseMapper;
import com.tech.interview.rmsflights.util.mapper.response.TunisairToRMSResponseMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {

    private RMSToTunisairRequestMapper rmsToTunisairRequestMapper
            = Mappers.getMapper(RMSToTunisairRequestMapper.class);

    private RMSToNouvelairRequestMapper rmsToNouvelairRequestMapper
            = Mappers.getMapper(RMSToNouvelairRequestMapper.class);

    private TunisairToRMSResponseMapper tunisairToRMSResponseMapper
            = Mappers.getMapper(TunisairToRMSResponseMapper.class);

    private NouvelairToRMSResponseMapper nouvelairToRMSResponseMapper
            = Mappers.getMapper(NouvelairToRMSResponseMapper.class);

    @Test
    public void rmsToTunisairRequest_whenMaps_thenCorrect() {
        RmsFlightsRequest rmsRequest = new RmsFlightsRequest("TUN", "FRA", "2022-07-30", "2022-07-30", 5);

        TunisAirRequest tunisAirRequest = rmsToTunisairRequestMapper.entityToResponseMapper(rmsRequest);

        assertEquals(tunisAirRequest.getOrigin(), rmsRequest.getOrigin());
        assertEquals(tunisAirRequest.getDestination(), rmsRequest.getDestination());
        assertEquals(tunisAirRequest.getDepartureDate(), rmsRequest.getDepartureDate());
        assertEquals(tunisAirRequest.getReturnDate(), rmsRequest.getReturnDate());
        assertEquals(tunisAirRequest.getPassengerCount(), rmsRequest.getNumberOfPassengers());
    }

    @Test
    public void rmsToNouvelairRequest_whenMaps_thenCorrect() {
        RmsFlightsRequest rmsRequest = new RmsFlightsRequest("TUN", "FRA", "2022-07-30", "2022-07-30", 5);

        NouvelairRequest nouvelairRequest = rmsToNouvelairRequestMapper.entityToResponseMapper(rmsRequest);

        assertEquals(nouvelairRequest.getFrom(), rmsRequest.getOrigin());
        assertEquals(nouvelairRequest.getTo(), rmsRequest.getDestination());
        assertEquals(nouvelairRequest.getOutboundDate(), rmsRequest.getDepartureDate());
        assertEquals(nouvelairRequest.getInboundDate(), rmsRequest.getReturnDate());
        assertEquals(nouvelairRequest.getNumberOfAdults(), rmsRequest.getNumberOfPassengers());
    }

    @Test
    public void tunisairToRmsResponse_whenMaps_thenCorrect() {
        TunisairResponse tunisairResponse = new TunisairResponse("Tunisair", 10.2, "E", "TUN", "FRA", "2022-07-30", "2022-07-30");

        RmsFlightsResponse rmsFlightsResponse = tunisairToRMSResponseMapper.entityToResponseMapper(tunisairResponse);

        assertEquals(rmsFlightsResponse.getAirline(), tunisairResponse.getAirline());
        assertEquals(rmsFlightsResponse.getDepartureDate(), tunisairResponse.getDepartureDate());
        assertEquals(rmsFlightsResponse.getArrivalDate(), tunisairResponse.getArrivalDate());
        assertEquals(rmsFlightsResponse.getDepartureAirportCode(), tunisairResponse.getDepartureAirportCode());
        assertEquals(rmsFlightsResponse.getDestinationAirportCode(), tunisairResponse.getDestinationAirportCode());
    }

    @Test
    public void nouvelairToRmsResponse_whenMaps_thenCorrect() {
        NouvelairResponse nouvelairResponse = new NouvelairResponse("Nouvelair", 10.2, 11.2, 12.2, "TUN", "FRA", "2022-07-30", "2022-07-30");

        RmsFlightsResponse rmsFlightsResponse = nouvelairToRMSResponseMapper.entityToResponseMapper(nouvelairResponse);

        assertEquals(rmsFlightsResponse.getAirline(), nouvelairResponse.getCarrier());
        assertEquals(rmsFlightsResponse.getDepartureDate(), nouvelairResponse.getOutboundDateTime());
        assertEquals(rmsFlightsResponse.getArrivalDate(), nouvelairResponse.getInboundDateTime());
        assertEquals(rmsFlightsResponse.getDepartureAirportCode(), nouvelairResponse.getDepartureAirportName());
        assertEquals(rmsFlightsResponse.getDestinationAirportCode(), nouvelairResponse.getDestinationAirportName());
    }
}
