package com.vegasattractions.vegasmainattractions.domain.vegasattractions.services;

import com.vegasattractions.vegasmainattractions.domain.core.exceptions.ResourceCreationException;
import com.vegasattractions.vegasmainattractions.domain.core.exceptions.ResourceNotFoundException;
import com.vegasattractions.vegasmainattractions.domain.vegasattractions.models.VegasAttractions;
import com.vegasattractions.vegasmainattractions.domain.vegasattractions.repos.VegasAttractionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegasAttractionsServiceImpl implements VegasAttractionsService{
    private VegasAttractionsRepo vegasAttractionsRepo;
@Autowired
    public VegasAttractionsServiceImpl(VegasAttractionsRepo vegasAttractionRepo) {
        this.vegasAttractionsRepo = vegasAttractionRepo;
    }

    @Override
    public VegasAttractions create(VegasAttractions vegasAttractions) throws ResourceCreationException {
        Optional<VegasAttractions> optional = vegasAttractionsRepo.findByEmail(vegasAttractions.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Request with email exists: " + vegasAttractions.getEmail());
        return vegasAttractionsRepo.save(vegasAttractions);
    }

    @Override
    public VegasAttractions getById(Long id) throws ResourceNotFoundException {
        VegasAttractions vegasAttractions = vegasAttractionsRepo .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No request with id: " + id));
        return vegasAttractions;
    }

    @Override
    public VegasAttractions getByEmail(String email) throws ResourceNotFoundException {
        VegasAttractions vegasAttractions = vegasAttractionsRepo.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("No request with email: " + email));
        return vegasAttractions;
    }

    @Override
    public List<VegasAttractions> getAll() {
        return vegasAttractionsRepo.findAll();
    }

    @Override
    public VegasAttractions update(Long id, VegasAttractions vegasAttractionsDetail) throws ResourceNotFoundException {
        VegasAttractions vegasAttractions = vegasAttractionsRepo.getById(id);
        vegasAttractions.setFirstName(vegasAttractionsDetail.getFirstName());
        vegasAttractions.setLastName(vegasAttractionsDetail.getLastName());
        vegasAttractions.setEmail(vegasAttractionsDetail.getEmail());
        vegasAttractions.setPOI(vegasAttractionsDetail.getPOI());
        vegasAttractions.setDateRange(vegasAttractionsDetail.getDateRange());
        vegasAttractions = vegasAttractionsRepo.save(vegasAttractions);
        return vegasAttractions;
    }

    @Override
    public void delete(Long id) {
        VegasAttractions vegasAttractions = getById(id);
        vegasAttractionsRepo.delete(vegasAttractions);

    }
}
