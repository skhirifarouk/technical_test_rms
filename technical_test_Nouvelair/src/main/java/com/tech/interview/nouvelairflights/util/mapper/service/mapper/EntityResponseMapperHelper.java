package com.tech.interview.nouvelairflights.util.mapper.service.mapper;

import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
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
     * @param nouvelairFlightList
     * @return
     */
    public List<NouvelairResponse> modelToResponseListMapper(List<NouvelairFlight> nouvelairFlightList) {
        return nouvelairFlightList.stream().map(x -> modelToResponseMapper(x)).collect(Collectors.toList());
    }

    /**
     * Map from entity list to response list
     * @param nouvelairFlight
     * @return
     */
    public NouvelairResponse modelToResponseMapper(NouvelairFlight nouvelairFlight) {
        return mapper.entityToResponseMapper(nouvelairFlight);
    }

    /**
     * Helper instance
     */
    public interface NouvelairModelResponseMapperHelperHolder {
        EntityResponseMapperHelper INSTANCE = new EntityResponseMapperHelper();
    }
}
