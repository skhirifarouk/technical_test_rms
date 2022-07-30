package com.tech.interview.tunisairflights;

import com.tech.interview.tunisairflights.domain.TunisairResponse;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import com.tech.interview.tunisairflights.util.mapper.EntityResponseMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Mapper test
 */
public class ResponseMapperTest {

    private EntityResponseMapper mapper
            = Mappers.getMapper(EntityResponseMapper.class);

    @Test
    public void givenEntiyToResponse_whenMaps_thenCorrect() {
        TunisairFlight entity = new TunisairFlight("tunisair", 10.2, "class", "TUN", "FRA", new Date(), new Date(), 6);

        TunisairResponse response = mapper.entityToResponseMapper(entity);
        assertEquals(response.getAirline(), entity.getAirline());
        assertEquals(response.getCabinclass(), entity.getCabinclass());
        assertEquals(response.getDepartureAirportCode(), entity.getDepartureAirportCode());
        assertEquals(response.getDestinationAirportCode(), entity.getDestinationAirportCode());
    }
}
