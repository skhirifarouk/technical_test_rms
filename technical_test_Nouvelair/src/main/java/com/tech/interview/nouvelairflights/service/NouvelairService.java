package com.tech.interview.nouvelairflights.service;


import com.tech.interview.nouvelairflights.domain.NouvelairRequest;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import com.tech.interview.nouvelairflights.persistence.querybuilder.NouvelairSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Service
 */
@Service
public class NouvelairService {

    @Autowired
    com.tech.interview.nouvelairflights.persistence.NouvelairRepository NouvelairRepository;

    public List<NouvelairFlight> findAll() {
        return NouvelairRepository.findAll();
    }

    public List<NouvelairFlight> findByRequest(NouvelairRequest request) {

        // Qeury filter specification
        Specification<NouvelairFlight> specification =
                // Departure country contains
                Specification.where(StringUtils.isEmpty(request.getFrom()) ? null :
                                NouvelairSpecification.departureContains(request.getFrom()))
                        // Arrival country contains
                        .and(StringUtils.isEmpty(request.getTo()) ? null :
                                NouvelairSpecification.destinationContains(request.getTo()))
                        // Outbound date
                        .and(StringUtils.isEmpty(request.getOutboundDate()) ? null :
                                NouvelairSpecification.outboundDateFrom(request.getOutboundDate()))
                        // Inbound date
                        .and(StringUtils.isEmpty(request.getInboundDate()) ? null :
                                NouvelairSpecification.inboundDateTo(request.getInboundDate()))
                        // Number of adults
                        .and(request.getNumberOfAdults() == 0 ? null :
                                NouvelairSpecification.numberOfAdultsLessOfEqual(request.getNumberOfAdults()));

        // Find data
        return NouvelairRepository.findAll(specification);
    }

    public NouvelairFlight save(@Valid NouvelairFlight nouvelairflight) {
        return NouvelairRepository.save(nouvelairflight);
    }
}
