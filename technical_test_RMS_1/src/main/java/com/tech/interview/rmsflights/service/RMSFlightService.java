package com.tech.interview.rmsflights.service;


import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import com.tech.interview.rmsflights.exception.ResourceNotFoundException;
import com.tech.interview.rmsflights.proxy.NouvelairServiceProxy;
import com.tech.interview.rmsflights.proxy.TunisairServiceProxy;
import com.tech.interview.rmsflights.util.mapper.request.RMSToNouvelairRequestMapperHelper.RMSToNouvelairRequestMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.request.RMSToTunisairRequestMapperHelper.RMSToTunisairRequestMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.response.NouvelairToRMSResponseMapperHelper.NouvelairToRMSResponseMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.response.TunisairToRMSResponseMapperHelper.TunisairToRMSResponseMapperHelperHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Service
 */
@Service
public class RMSFlightService {


    private final TunisairServiceProxy tunisairServiceProxy;
    private final NouvelairServiceProxy nouvelairServiceProxy;

    /**
     * Contructor with parameters
     *
     * @param tunisairServiceProxy
     * @param nouvelairServiceProxy
     */
    public RMSFlightService(TunisairServiceProxy tunisairServiceProxy, NouvelairServiceProxy nouvelairServiceProxy) {
        this.tunisairServiceProxy = tunisairServiceProxy;
        this.nouvelairServiceProxy = nouvelairServiceProxy;
    }

    /**
     * Get Tunisair flight results
     *
     * @param request
     * @return
     * @throws ResourceNotFoundException
     */
    public List<RmsFlightsResponse> getResponseFromTunisair(RmsFlightsRequest request) throws ResourceNotFoundException {
        List<TunisairResponse> tunisairResponseList = tunisairServiceProxy.getByRequest(RMSToTunisairRequestMapperHelperHolder.INSTANCE.map(request)).getBody();
        return TunisairToRMSResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(tunisairResponseList);
    }

    /**
     * Get Nouvelair flight results
     *
     * @param request
     * @return
     * @throws ResourceNotFoundException
     */
    public List<RmsFlightsResponse> getResponseFromNouvelair(RmsFlightsRequest request) throws ResourceNotFoundException {
        List<NouvelairResponse> nouvelairResponseList = nouvelairServiceProxy.getByRequest(RMSToNouvelairRequestMapperHelperHolder.INSTANCE.map(request)).getBody();
        return NouvelairToRMSResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(nouvelairResponseList);
    }
}
