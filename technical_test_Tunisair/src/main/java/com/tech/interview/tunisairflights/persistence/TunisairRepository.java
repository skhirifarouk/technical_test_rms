package com.tech.interview.tunisairflights.persistence;

import com.tech.interview.tunisairflights.model.TunisairFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository
 */
@Repository
public interface TunisairRepository extends JpaRepository<TunisairFlight, Long>, JpaSpecificationExecutor<TunisairFlight> {
}
