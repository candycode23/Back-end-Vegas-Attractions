package com.vegasattractions.vegasmainattractions.domain.vegasattractions.services;

import com.vegasattractions.vegasmainattractions.domain.core.exceptions.ResourceCreationException;
import com.vegasattractions.vegasmainattractions.domain.core.exceptions.ResourceNotFoundException;
import com.vegasattractions.vegasmainattractions.domain.vegasattractions.models.VegasAttractions;

import java.util.List;

public interface VegasAttractionsService {
    VegasAttractions create(VegasAttractions vegasAttractions) throws ResourceCreationException;

    VegasAttractions getById(Long id) throws ResourceNotFoundException;

    VegasAttractions getByEmail(String email) throws ResourceNotFoundException;

    List<VegasAttractions> getAll();

    VegasAttractions update(Long id, VegasAttractions vegasAttractionsDetail) throws ResourceNotFoundException;

    void delete(Long Id);

}
