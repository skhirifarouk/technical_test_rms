package com.tech.interview.tunisairflights.util.mapper.service.mapper;

import com.tech.interview.tunisairflights.domain.tunisair.TunisairResponse;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper helper
 */
public class EntityResponseMapperHelper {

    EntityResponseMapper mapper = Mappers.getMapper(EntityResponseMapper.class);

    /**
     * Map from entity to response
     * @param tunisAirFlightList
     * @return
     */
    public List<TunisairResponse> modelToResponseListMapper(List<TunisairFlight> tunisAirFlightList) {
        return tunisAirFlightList.stream().map(x -> modelToResponseMapper(x)).collect(Collectors.toList());
    }

    /**
     * Map from entity list to response list
     * @param tunisAirFlight
     * @return
     */
    public TunisairResponse modelToResponseMapper(TunisairFlight tunisAirFlight) {
        return mapper.entityToResponseMapper(tunisAirFlight);
    }

    /**
     * Helper instance
     */
    public interface TunisAirModelResponseMapperHelperHolder {
        EntityResponseMapperHelper INSTANCE = new EntityResponseMapperHelper();
    }
}
