package com.tech.interview.tunisairflights.service;

import com.tech.interview.tunisairflights.domain.tunisair.TunisAirRequest;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import com.tech.interview.tunisairflights.persistence.TunisairRepository;
import com.tech.interview.tunisairflights.persistence.querybuilder.TunisairSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class TunisairService {

    @Autowired
    TunisairRepository tunisairRepository;

    public List<TunisairFlight> findAll() {
        return tunisairRepository.findAll();
    }

    public List<TunisairFlight> findByRequest(TunisAirRequest request) {
        Specification<TunisairFlight> specification =
                Specification.where(StringUtils.isEmpty(request.getOrigin()) ? null :
                        TunisairSpecification.originContains(request.getOrigin()))
                        .and(StringUtils.isEmpty(request.getDestination()) ? null :
                                TunisairSpecification.destinationContains(request.getDestination()))
                        .and(StringUtils.isEmpty(request.getDepartureDate()) ? null :
                                TunisairSpecification.departureDateFrom(request.getDepartureDate()))
                        .and(StringUtils.isEmpty(request.getReturnDate()) ? null :
                                TunisairSpecification.returnDateTo(request.getReturnDate()))
                        .and(request.getPassengerCount() == 0 ? null :
                                TunisairSpecification.passengerCountLessOrEqual(request.getPassengerCount()));
        return tunisairRepository.findAll(specification);
    }

    public TunisairFlight save(TunisairFlight tunisAirflight) {
        return tunisairRepository.save(tunisAirflight);
    }
}
