package com.vegasattractions.vegasmainattractions.domain.vegasattractions.repos;

import com.vegasattractions.vegasmainattractions.domain.vegasattractions.models.VegasAttractions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VegasAttractionsRepo extends JpaRepository <VegasAttractions, Long> {
    Optional<VegasAttractions> findByEmail(String email);
}
