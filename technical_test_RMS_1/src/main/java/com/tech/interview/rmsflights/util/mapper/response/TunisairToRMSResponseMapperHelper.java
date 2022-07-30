package com.tech.interview.rmsflights.util.mapper.response;

import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

public class TunisairToRMSResponseMapperHelper {
    private final TunisairToRMSResponseMapper mapper = Mappers.getMapper(TunisairToRMSResponseMapper.class);

    /**
     * Map object list
     *
     * @param rmsResponseList
     * @return
     */
    public List<RmsFlightsResponse> modelToResponseListMapper(List<TunisairResponse> rmsResponseList) {
        return rmsResponseList.stream().map(this::modelToResponseMapper).collect(Collectors.toList());
    }

    /**
     * Map object
     *
     * @param TunisairResponse
     * @return
     */
    public RmsFlightsResponse modelToResponseMapper(TunisairResponse TunisairResponse) {
        return mapper.entityToResponseMapper(TunisairResponse);
    }

    /**
     * Helper instance
     */
    public interface TunisairToRMSResponseMapperHelperHolder {
        TunisairToRMSResponseMapperHelper INSTANCE = new TunisairToRMSResponseMapperHelper();
    }
}
