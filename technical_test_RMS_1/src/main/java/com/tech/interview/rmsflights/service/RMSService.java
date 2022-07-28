package com.tech.interview.rmsflights.service;


import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Service
 */
@Service
public class RMSService {


    public List<NouvelairResponse> findByRequest(NouvelairRequest request) {
       return null;
    }

    public NouvelairRequest save(@Valid NouvelairRequest nouvelairflight) {
        return null;
    }
}
