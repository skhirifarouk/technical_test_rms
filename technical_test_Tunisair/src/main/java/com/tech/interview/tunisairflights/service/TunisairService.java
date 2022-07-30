package com.tech.interview.tunisairflights.service;

import com.tech.interview.tunisairflights.domain.TunisAirRequest;
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

    /**
     * Find all
     *
     * @return
     */
    public List<TunisairFlight> findAll() {
        return tunisairRepository.findAll();
    }

    /**
     * Find entities by request parameters
     *
     * @param request
     * @return
     */
    public List<TunisairFlight> findByRequest(TunisAirRequest request) {
        // Specification according to request object
        Specification<TunisairFlight> specification =
                // Filter on origin
                Specification.where(StringUtils.isEmpty(request.getOrigin()) ? null :
                                TunisairSpecification.originContains(request.getOrigin()))
                        // Filter on destination
                        .and(StringUtils.isEmpty(request.getDestination()) ? null :
                                TunisairSpecification.destinationContains(request.getDestination()))
                        // Filter on departure date
                        .and(StringUtils.isEmpty(request.getDepartureDate()) ? null :
                                TunisairSpecification.departureDateFrom(request.getDepartureDate()))
                        // Filter on arrival date
                        .and(StringUtils.isEmpty(request.getReturnDate()) ? null :
                                TunisairSpecification.returnDateTo(request.getReturnDate()))
                        // Filter on passenger count
                        .and(request.getPassengerCount() == 0 ? null :
                                TunisairSpecification.passengerCountLessOrEqual(request.getPassengerCount()));

        // find result
        return tunisairRepository.findAll(specification);
    }

    /**
     * Save entity
     *
     * @param tunisAirflight
     * @return
     */
    public TunisairFlight save(TunisairFlight tunisAirflight) {
        return tunisairRepository.save(tunisAirflight);
    }
}
