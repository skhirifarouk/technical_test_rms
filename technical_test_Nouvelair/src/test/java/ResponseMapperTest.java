import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import com.tech.interview.nouvelairflights.util.mapper.EntityResponseMapper;
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
        NouvelairFlight entity = new NouvelairFlight("Nouvelair", 10.2, 1.2, 2.3, "TUN", "FRA", new Date(), new Date(), 5);

        NouvelairResponse response = mapper.entityToResponseMapper(entity);
        assertEquals(response.getCarrier(), entity.getCarrier());
        assertEquals(response.getBasePrice(), entity.getBasePrice());
        assertEquals(response.getTax(), entity.getTax());
        assertEquals(response.getDiscount(), entity.getDiscount());
        assertEquals(response.getDepartureAirportName(), entity.getDepartureAirportName());
        assertEquals(response.getDestinationAirportName(), entity.getDestinationAirportName());
    }
}
