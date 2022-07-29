package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.tunisair.TunisAirRequest;
import org.mapstruct.factory.Mappers;

/**
 * Mapper helper
 */
public class RMSToTunisairRequestMapperHelper {

    private final RMSToTunisairRequestMapper mapper = Mappers.getMapper(RMSToTunisairRequestMapper.class);

    /**
     * Map object
     * @param rmsFlightsRequest
     * @return
     */
    public TunisAirRequest map(RmsFlightsRequest rmsFlightsRequest) {
        return mapper.entityToResponseMapper(rmsFlightsRequest);
    }

    /**
     * Helper instance
     */
    public interface RMSToTunisairRequestMapperHelperHolder {
        RMSToTunisairRequestMapperHelper INSTANCE = new RMSToTunisairRequestMapperHelper();
    }
}
