package com.tech.interview.rmsflights.util.mapper.request;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import org.mapstruct.factory.Mappers;

public class RMSToNouvelairRequestMapperHelper {

    private final RMSToNouvelairRequestMapper mapper = Mappers.getMapper(RMSToNouvelairRequestMapper.class);

    /**
     * Map object
     * @param rmsFlightsRequest
     * @return
     */
    public NouvelairRequest map(RmsFlightsRequest rmsFlightsRequest) {
        return mapper.entityToResponseMapper(rmsFlightsRequest);
    }

    /**
     * Helper instance
     */
    public interface RMSToNouvelairRequestMapperHelperHolder {
        RMSToNouvelairRequestMapperHelper INSTANCE = new RMSToNouvelairRequestMapperHelper();
    }
}
