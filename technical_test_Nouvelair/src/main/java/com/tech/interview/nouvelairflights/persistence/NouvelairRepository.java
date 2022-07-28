package com.tech.interview.nouvelairflights.persistence;

import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository
 */
@Repository
public interface NouvelairRepository extends JpaRepository<NouvelairFlight, Long>, JpaSpecificationExecutor<NouvelairFlight> {
}
