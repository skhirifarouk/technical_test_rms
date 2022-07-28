import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import com.tech.interview.nouvelairflights.util.mapper.service.mapper.EntityResponseMapper;
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
        NouvelairFlight entity = new NouvelairFlight("Nouvelair", 10.2, "class", "TUN", "FRA", new Date(), new Date());

        NouvelairResponse response = mapper.entityToResponseMapper(entity);
        assertEquals(response.getAirline(), entity.getAirline());
        assertEquals(response.getCabinclass(), entity.getCabinclass());
        assertEquals(response.getDepartureAirportCode(), entity.getDepartureAirportCode());
        assertEquals(response.getDestinationAirportCode(), entity.getDestinationAirportCode());
    }
}
