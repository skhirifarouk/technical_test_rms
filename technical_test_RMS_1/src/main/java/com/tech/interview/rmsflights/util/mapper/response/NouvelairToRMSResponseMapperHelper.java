package com.tech.interview.rmsflights.util.mapper.response;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

public class NouvelairToRMSResponseMapperHelper {

    private final NouvelairToRMSResponseMapper mapper = Mappers.getMapper(NouvelairToRMSResponseMapper.class);

    /**
     * Map object list
     * @param rmsResponseList
     * @return
     */
    public List<RmsFlightsResponse> modelToResponseListMapper(List<NouvelairResponse> rmsResponseList) {
        return rmsResponseList.stream().map(this::modelToResponseMapper).collect(Collectors.toList());
    }

    /**
     * Map object
     * @param nouvelairResponse
     * @return
     */
    public RmsFlightsResponse modelToResponseMapper(NouvelairResponse nouvelairResponse) {
        return mapper.entityToResponseMapper(nouvelairResponse);
    }

    /**
     * Helper instance
     */
    public interface NouvelairToRMSResponseMapperHelperHolder {
        NouvelairToRMSResponseMapperHelper INSTANCE = new NouvelairToRMSResponseMapperHelper();
    }

}
