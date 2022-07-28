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
        Specification<NouvelairFlight> specification =
                Specification.where(StringUtils.isEmpty(request.getOrigin()) ? null :
                        NouvelairSpecification.originContains(request.getOrigin()))
                        .and(StringUtils.isEmpty(request.getDestination()) ? null :
                                NouvelairSpecification.destinationContains(request.getDestination()))
                        .and(StringUtils.isEmpty(request.getDepartureDate()) ? null :
                                NouvelairSpecification.departureDateFrom(request.getDepartureDate()))
                        .and(StringUtils.isEmpty(request.getReturnDate()) ? null :
                                NouvelairSpecification.returnDateTo(request.getReturnDate()));
        return NouvelairRepository.findAll(specification);
    }

    public NouvelairFlight save(@Valid NouvelairFlight nouvelairflight) {
        return NouvelairRepository.save(nouvelairflight);
    }
}
